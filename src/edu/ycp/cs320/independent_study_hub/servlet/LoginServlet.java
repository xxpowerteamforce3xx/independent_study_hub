package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectOneStudentController controller_student = new SelectOneStudentController();
	private SelectOneFacultyController controller_fac = new SelectOneFacultyController();
	private Student s = new Student();
	private Faculty f = new Faculty();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doPost");
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		boolean validLogin  = false;

		// Decode form parameters and dispatch to controller
		name = req.getParameter("username");
		pw   = req.getParameter("pass");

		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if (name == null || pw == null || name.equals("") || pw.equals("")) {
			errorMessage = "Please specify both user name and password";
		} else {
			controller_student.get_student(name);
			controller_fac.get_faculty(name);
			

			if (!validLogin) {
				errorMessage = "Username and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login",        validLogin);

		// if login is valid, start a session
		if (validLogin) {
			System.out.println("   Valid login - starting session, redirecting to /index");

			// store user object in session
			req.getSession().setAttribute("user", name);

			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/index");

			return;
		}

		System.out.println("   Invalid login - returning to /Login");

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
	}
	
}
