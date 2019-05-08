package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
import edu.ycp.cs320.independent_study_hub.model.*;

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
		String email 		= null;
		String check1       = null;
		String check2       = null;
		String check3		= null;
		String button       = null;
		boolean valid  = false;

		// Decode form parameters and dispatch to controller
		button = req.getParameter("button");
		name = req.getParameter("name");
		pw   = req.getParameter("pass");
		check1 = req.getParameter("check");
		check2 = req.getParameter("check_stdnt");
		check3 = req.getParameter("check_fac");
		
		try {
			if (button.equals("Create")) {
				if (check2 != null) { // tried to create a stdnt account
					System.out.println("tried to create a new account");
					resp.sendRedirect(req.getContextPath() + "/NewStudent");
					return;
				} else if (check3 != null) { // tried to create a fac acc
					System.out.println("tried to create a fac acc");
					resp.sendRedirect(req.getContextPath() + "/NewFaculty");
				} else {
					System.out.println("tried to create an account but didnt check the box");
					errorMessage = "If you want to create an account, check the box! How hard can it be?";
					req.setAttribute("errorMessage", errorMessage);
				}
			}
		} catch (NullPointerException e) {}
		
		try {
			if (button.equals("Login")) { // tried to login as an existing user
				if (check1 != null && check1.equals("1")) {
					req.getSession().setAttribute("user", "guest");
					req.getSession().setAttribute("type", "guest");
					resp.sendRedirect(req.getContextPath() + "/Home");
					return;
				}
			}
		} catch (NullPointerException e) {}
		
		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if ((name == null || pw == null) || (name.equals("") || pw.equals(""))) {
			if (errorMessage == null)
				errorMessage = "You gotta enter something buddy come on now";
		} else {
			pw = MD5.getMd5(pw);	// hashing our password to matched the stored one in the db
			s = controller_student.get_student(name);
			f = controller_fac.get_faculty(name);
			System.out.println("faculty name: " + f.get_name() + "faculty pw: " + f.get_password() );
			try {
				if (s.get_name().equals(name) && s.get_password().equals(pw)) { 
					valid = true;
					email = s.get_email();
					req.getSession().setAttribute("type", "student");
				} 
			} catch (NullPointerException e) {
				errorMessage = "Well, I don't think either your username or password could be more wrong than they were so";
			}
			try {
				System.out.println("password given: " + pw);
				if (f.get_name().equals(name) && f.get_password().equals(pw)) {
					valid = true;
					System.out.println("made it here");
					email = f.get_email();
					req.getSession().setAttribute("type", "faculty");
					System.out.println(f.get_fac_code());
					req.getSession().setAttribute("fac_code", f.get_fac_code());
				}
			} catch (NullPointerException e) {
					errorMessage = "Well, I don't think either your username or password could be more wrong than they were so";
			}
		}
		
		// Add parameters as request attributes
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("pass", req.getParameter("pass"));

		// Add result objects as request attributes
		
		req.setAttribute("login", valid);
		// if login is valid, start a session
		if (valid) {
			errorMessage = null;
			System.out.println("   Valid login - starting session, redirecting to /Home");

			// store user object in session
			req.getSession().setAttribute("user", name);
			req.getSession().setAttribute("pw", pw);
			req.getSession().setAttribute("email", email);

			// redirect to /home page
			resp.sendRedirect(req.getContextPath() + "/Home");

			return;
		}
		
		System.out.println("   Invalid login - returning to /Login");
		req.setAttribute("errorMessage", errorMessage);

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
			
	}
		
}
