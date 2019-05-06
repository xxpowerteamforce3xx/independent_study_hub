package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.independent_study_hub.model.*;
import edu.ycp.cs320.independent_study_hub.controller.InsertStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllStudentsController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectProjectsByStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectStudentsByFacCodeController;

public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectProjectsByStudentController controller_projects = new SelectProjectsByStudentController();
	private SelectStudentsByFacCodeController controller_students = new SelectStudentsByFacCodeController();
	private SelectAllStudentsController controller_all_students = new SelectAllStudentsController();
	private SelectOneFacultyController controller_one_fac = new SelectOneFacultyController();
	private List<Project> p_list = new ArrayList<Project>();
	private ArrayList<Student> s_list = new ArrayList<Student>();
	private ArrayList<Student> all_students = new ArrayList<Student>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyAccount servlet doGet");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		String email        = null;
		String code 		= null;
		String type			= null;
		
		name = (String) req.getSession().getAttribute("user");
		pw = (String) req.getSession().getAttribute("pw");
		email = (String) req.getSession().getAttribute("email");
		code = (String) req.getSession().getAttribute("fac_code");
		System.out.println(code + " fac code");
		type = (String) req.getSession().getAttribute("type");
		try {
			if (type.equals("student")) {
				p_list = controller_projects.SelectProjectsByStudent(name);
				req.setAttribute("projects", p_list);
			} else if (type.equals("faculty")) {
				Faculty f = controller_one_fac.get_faculty(name);
				s_list = controller_students.SelectStudentByFacCode(f.get_fac_code());
				all_students = controller_all_students.get_all_students();
				req.setAttribute("students", s_list);
				req.setAttribute("all_students", all_students);
			}
		} catch(NullPointerException e) {}
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("name", name);
		req.setAttribute("pass", pw);
		req.setAttribute("email", email);
		req.setAttribute("code", code);
		req.setAttribute("type", type);
		
		req.getRequestDispatcher("/_view/MyAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("MyAccount servlet doPost");
		String back = null;
		String logout = null;
		String update = null;
		back = req.getParameter("account");
		logout = req.getParameter("logout");
		update = req.getParameter("update");
		try {
			if (logout.equals("Log out")) {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + "/Login");
			}
		} catch (NullPointerException e) {}
		try {
			if (back.equals("Back to Home")) {
				System.out.println("redirecting to home");
				resp.sendRedirect(req.getContextPath() + "/Home");
			}
		} catch (NullPointerException e) {}
		try {
			if (update.equals("update")) {
				System.out.println("redirecting to update");
				resp.sendRedirect(req.getContextPath() + "/Update");
			}
		} catch (NullPointerException e) {}
	}
	
}
