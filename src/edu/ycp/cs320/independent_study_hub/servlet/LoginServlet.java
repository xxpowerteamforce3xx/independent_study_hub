package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
import java.util.Random;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectOneStudentController controller_student = new SelectOneStudentController();
	private SelectOneFacultyController controller_fac = new SelectOneFacultyController();
	private Student s = new Student();
	private Faculty f = new Faculty();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("errorMessage", "Login");
		System.out.println("Login Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 Random random = new Random();
	    int x = random.nextInt((4 - 1) + 1) + 1;
		System.out.println("Login Servlet: doPost");
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		boolean valid  = false;

		// Decode form parameters and dispatch to controller
		name = req.getParameter("name");
		pw   = req.getParameter("pass");

		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if (name == null || pw == null || name.equals("") || pw.equals("")) {
			if (x == 1)
				errorMessage = "Not even close, try again";
			if (x == 2)
				errorMessage = "Do you even go here buddy?";
			if (x == 3)
				errorMessage = "Is that even english?";
			if (x == 4)
				errorMessage = "Wait till I show the guys that try, they'll love that one";
			
		} else {
			s = controller_student.get_student(name);
			f = controller_fac.get_faculty(name);
			System.out.println(s.get_name() + ", " + s.get_password());
			if (s.get_name().equals(name) && s.get_password().equals(pw)) { 
				valid = true;
			} else if (f.get_name() == name && f.get_password() == pw) {
				valid = true;
			}
			if (!valid) {
				errorMessage = "Username and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("pass", req.getParameter("pass"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login",        valid);

		// if login is valid, start a session
		if (valid) {
			System.out.println("   Valid login - starting session, redirecting to /Home");

			// store user object in session
			req.getSession().setAttribute("user", name);

			// redirect to /home page
			resp.sendRedirect(req.getContextPath() + "/Home");

			return;
		}

		System.out.println("   Invalid login - returning to /Login");

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
		
	}
	
}
