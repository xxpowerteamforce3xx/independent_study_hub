package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.InsertStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.MD5;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class NewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectOneStudentController controller_student = new SelectOneStudentController();
	private InsertStudentController controller_insert_student = new InsertStudentController();
	private SelectAllFacultyController controller_all_fac = new SelectAllFacultyController();
	private Student s = new Student();
	private ArrayList<Faculty> f_list = new ArrayList<Faculty>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		

		req.getRequestDispatcher("/_view/NewStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("NewStudent servlet doPost");
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		String pw2			= null;
		String fac_code     = null;
		String email        = null;
		Boolean bool 		= false;
		
		name = req.getParameter("name");
		pw = req.getParameter("pass");
		pw2 = req.getParameter("pass2");
		email = req.getParameter("email");
		fac_code = req.getParameter("fac_code");
		// first we see if the code they enter matches any fac codes on db
		f_list = controller_all_fac.get_all_faculty();
		for (Faculty f : f_list) {
			if (f.get_fac_code() == fac_code)
				bool = true;
		}
		// first check fac_code
		if (bool) {
			// then we can keep checking
			// now we are checking to see if they are too big for our db to handle
			int name_length = name.length();
			int pw_length = name.length();
			int email_length = email.length();
			if (name_length > 10) {
				errorMessage = "username is too long, try again buddy";
			} else if (pw_length > 10) {
				errorMessage = "password is too long, try again buddy";
			} else if (email_length > 20) {
				errorMessage = "What even is that? It's definitely not an email, that's for sure";
			} else if (!pw.equals(pw2)) {
				errorMessage = "Your passwords don't match, try again my guy";
			} else { // we can keep going
				// now we check to see if it is a valid email
				if (!email.contains("@ycp.edu")) { // not valid email
					errorMessage = "Your email is invalid. Please use your YCP email or try again";
				} else {
					// now we check to see if a student exists
					s = controller_student.get_student(name);
					try {
						if (s.get_name().equals(name) || s.get_email().equals(email)) { // student exists
							errorMessage = "A student with that username or email already exists within our system, try again";
						} 
					} catch (NullPointerException e) { // a null pointer means the student didnt already exists!
						// now we can create the student!
						System.out.println("new Student : " + name + ", " + pw + ", "+ email);
						pw = MD5.getMd5(pw);
						controller_insert_student.insertStudent(name, pw, email);
						// now we log them in!
						req.getSession().setAttribute("user", name);
						resp.sendRedirect(req.getContextPath() + "/Home");
					}
				}
			}
		} else {
			System.out.println("here");
			errorMessage = "Faculty Code is either not right, or empty. If you need a code, please contact an administrator";
		}
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("name", name);
		req.setAttribute("pass", pw);
		req.setAttribute("email", email);
		req.setAttribute("fac_code", fac_code);
		req.getRequestDispatcher("/_view/NewStudent.jsp").forward(req, resp);
	}
	
}
