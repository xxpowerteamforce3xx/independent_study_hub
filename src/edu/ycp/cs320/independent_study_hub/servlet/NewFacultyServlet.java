package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.InsertPendingFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.InsertStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class NewFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectOneFacultyController controller_get_fac = new SelectOneFacultyController();
	private InsertPendingFacultyController controller_pending = new InsertPendingFacultyController();
	private Faculty f = new Faculty();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		

		req.getRequestDispatcher("/_view/NewFaculty.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("NewStudent servlet doPost");
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		String pw2			= null;
		String email        = null;
		
		name = req.getParameter("name");
		pw = req.getParameter("pass");
		pw2 = req.getParameter("pass2");
		email = req.getParameter("email");

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
			errorMessage = "Your passwords don't match, try again";
		} else { // we can keep going
			// now we check to see if it is a valid email
			if (!email.contains("@ycp.edu")) { // not valid email
				errorMessage = "Your email is invalid. Please use your YCP email";
			} else {
				// now we check to see if the fac already exists
				f = controller_get_fac.get_faculty(name);
				try {
					if (f.get_name().equals(name) || f.get_email().equals(email)) { // student exists
						errorMessage = "A faculty member with that username or email already exists within our system, contact an administrator for help";
					} 
				} catch (NullPointerException e) { // a null pointer means the student didnt already exists!
					// now we can create the student!
					System.out.println("new pending fac: " + name + ", " + pw + ", "+ email);
					controller_pending.InsertPendingFaculty(name, pw, email);
					resp.sendRedirect(req.getContextPath() + "/ThankYou");
				}
			}
		}
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("name", name);
		req.setAttribute("pass", pw);
		req.setAttribute("email", email);
		req.getRequestDispatcher("/_view/NewFaculty.jsp").forward(req, resp);
	}
	
}
