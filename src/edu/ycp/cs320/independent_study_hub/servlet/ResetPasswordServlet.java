package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.SelectAllFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllProjectsController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllStudentsController;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.*;

public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectAllStudentsController controller_students = new SelectAllStudentsController();
	private SelectAllFacultyController controller_faculty = new SelectAllFacultyController();
	private ArrayList<Student> all_students = new ArrayList<Student>();
	private ArrayList<Faculty> all_faculty = new ArrayList<Faculty>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.

		System.out.println("ResetPassowrd Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
			
		req.getRequestDispatcher("/_view/ResetPassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Research servlet doPost");
		String email = null;
		String errorMessage = null;
		Boolean found = false;
		Boolean valid = true;
		email = req.getParameter("email");
		try {
			email = req.getParameter("email");
			if (email != null) {
				System.out.println(email + "<-- recipient of generic email");
				if (!email.contains("@ycp.edu") || email == null) {	// first check to see if it is a ycp email
					valid = false;
					errorMessage = "Email address given is not a YCP email, please use your YCP email";
				} 
				
				// now we check if they are in our db to determine the message we send
				all_students = controller_students.get_all_students();
				all_faculty = controller_faculty.get_all_faculty();
				for (Student s: all_students) {
					if (s.get_email().equals(email)) {
						found = true;
						break;
					}
				}
				
				for (Faculty f: all_faculty) {
					if (f.get_email().equals(email)) {
						found = true; 
						break;
					}
				}
				if (valid) {
					JavaEmail.run(email, found);
					req.getRequestDispatcher("/_view/EmailSent.jsp").forward(req, resp);
				}
			}
		} catch (NullPointerException e) {System.out.println("Something was null -- dopost of resetpassword");} catch (AddressException e) { e.printStackTrace();} catch (MessagingException e) {e.printStackTrace();}
		req.setAttribute("errorMessage", errorMessage);
		req.getRequestDispatcher("/_view/ResetPassword.jsp").forward(req, resp);	
	}
		
}
	
	
