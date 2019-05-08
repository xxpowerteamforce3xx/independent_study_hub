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
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectProjectsByStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectStudentsByFacCodeController;
import edu.ycp.cs320.independent_study_hub.controller.UpdateStudentController;
import edu.ycp.cs320.independent_study_hub.controller.UpdateFacultyController;

public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateStudentController controller_s = new UpdateStudentController();
	private UpdateFacultyController controller = new UpdateFacultyController();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Update servlet doGet");
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
	
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("name", name);
		req.setAttribute("pass", pw);
		req.setAttribute("email", email);
		req.setAttribute("code", code);
		req.setAttribute("type", type);
		
		req.getRequestDispatcher("/_view/Update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("UpdateServlet servlet doPost");
		String old_name         = null;
		String old_pw           = null;
		String old_email        = null;

		old_name = (String) req.getSession().getAttribute("user");
		old_pw = (String) req.getSession().getAttribute("pw");
		old_email = (String) req.getSession().getAttribute("email");
		
		String back = null;
		String logout = null;
		back = req.getParameter("account");
		logout = req.getParameter("logout");
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
		if (req.getSession().getAttribute("type").equals("faculty")) {
			String errorMessage = null;
			String new_name = null;
			String new_pass = null;
			String new_pass2 = null;
			String new_email = null;
			String new_fac_code = null;
			Boolean valid = true;
			
			new_name = (String) req.getParameter("new_name");
			new_pass = (String) req.getParameter("new_password");
			new_pass2 = (String) req.getParameter("new_password2");
			new_email = (String) req.getParameter("new_email");
			new_fac_code = (String) req.getParameter("new_fac_code");
			System.out.println("new_name: " + new_name + ", new pass: " + new_pass + ", new email: " + new_email + ", new code: " + new_fac_code);
			
			try {
				if (new_name == null || new_name.equals("") || new_pass == null || new_pass.equals("") || new_pass2 == null || new_pass2.equals("") || new_email == null || new_email.equals("") || new_fac_code == null || new_fac_code.equals("")) {
					errorMessage = "Please enter all fields";
					System.out.println("something was null or empty");
					valid = false;
				}
			} catch (NullPointerException e) {}
			try {
				if (!new_email.contains("@ycp.edu")) {
					errorMessage = "Please enter a YCP email thanks";
					valid = false;
				}
			} catch (NullPointerException e) {}
			try {
				if (!new_pass.equals(new_pass2)) {
					errorMessage = "Your Passwords do not match, fix it my guy";
					valid = false;
				}
			} catch (NullPointerException e) {}
			
			if (valid) {
				new_pass = MD5.getMd5(new_pass);
				controller.UpdateFaculty(new_email, old_name, new_pass, new_name, new_fac_code);
				req.getSession().setAttribute("user", new_name);
				req.getSession().setAttribute("pw", new_pass);
				req.getSession().setAttribute("email", new_email);
				req.getSession().setAttribute("fac_code", new_fac_code);
				System.out.println(req.getSession().getAttribute("user"));
				resp.sendRedirect(req.getContextPath() + "/MyAccount");
			}
			
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("new_name", new_name);
			req.setAttribute("new_password", new_pass);
			req.setAttribute("new_email", new_email);
			req.setAttribute("new_fac_code", new_fac_code);
			req.getRequestDispatcher("/_view/Update.jsp").forward(req, resp);
			
		} else if (req.getSession().getAttribute("type").equals("student")) {
			String errorMessage = null;
			String new_name = null;
			String new_pass = null;
			String new_pass2 = null;
			String new_email = null;
			Boolean valid = true;
			
			new_name = (String) req.getParameter("new_name");
			new_pass = (String) req.getParameter("new_password");
			new_pass2 = (String) req.getParameter("new_password2");
			new_email = (String) req.getParameter("new_email");

			System.out.println("new_name: " + new_name + ", new pass: " + new_pass + ", new email: " + new_email);
			
			try {
				if (new_name == null || new_name.equals("") || new_pass == null || new_pass.equals("") || new_pass2 == null || new_pass2.equals("") || new_email == null || new_email.equals("")) {
					errorMessage = "Please enter all fields";
					System.out.println("something was null or empty");
					valid = false;
				}
			} catch (NullPointerException e) {}
			try {
				if (!new_email.contains("@ycp.edu")) {
					errorMessage = "Please enter a YCP email thanks";
					valid = false;
				}
			} catch (NullPointerException e) {}
			try {
				if (!new_pass.equals(new_pass2)) {
					errorMessage = "Your Passwords do not match, fix it my guy";
					valid = false;
				}
			} catch (NullPointerException e) {}
			
			if (valid) {
				new_pass = MD5.getMd5(new_pass);
				controller_s.UpdateStudent(new_email, old_name, new_pass, new_name);
				req.getSession().setAttribute("user", new_name);
				req.getSession().setAttribute("pw", new_pass);
				req.getSession().setAttribute("email", new_email);
				System.out.println(req.getSession().getAttribute("user"));
				resp.sendRedirect(req.getContextPath() + "/MyAccount");
			}
			
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("new_name", new_name);
			req.setAttribute("new_password", new_pass);
			req.setAttribute("new_email", new_email);
			req.getRequestDispatcher("/_view/Update.jsp").forward(req, resp);
		}
	}
	
}
