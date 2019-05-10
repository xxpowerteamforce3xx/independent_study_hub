package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ycp.cs320.independent_study_hub.model.*;
import edu.ycp.cs320.independent_study_hub.controller.GetProjectController;
import edu.ycp.cs320.independent_study_hub.controller.InsertStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectProjectsByStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectStudentsByFacCodeController;
import edu.ycp.cs320.independent_study_hub.controller.UpdateStudentController;
import edu.ycp.cs320.independent_study_hub.controller.UpdateFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.UpdateProjectController;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateStudentController controller_s = new UpdateStudentController();
	private UpdateFacultyController controller = new UpdateFacultyController();
	private GetProjectController controller_prj = new GetProjectController();
	private UpdateProjectController controller_upd_prj = new UpdateProjectController();
	private SelectOneFacultyController controller_one_f = new SelectOneFacultyController();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Update servlet doGet");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		String errorMessage = null;
		// student stuff / a little fac stuff
		String name         = null;
		String pw           = null;
		String email        = null;
		String code 		= null;
		String type			= null;
		// project stuff
		String title		= null;
		String desc 		= null;
		// faculty stuff
		String fac_title 	= null;
		String fac_desc			= null;
		String interest 	= null;
		String file_name	= null;
		
		
		name = (String) req.getSession().getAttribute("user");
		pw = (String) req.getSession().getAttribute("pw");
		email = (String) req.getSession().getAttribute("email");
		code = (String) req.getSession().getAttribute("fac_code");
		type = (String) req.getSession().getAttribute("type");
		
		if (req.getParameter("id").equals("student")) {
			req.setAttribute("which", "student");
			req.setAttribute("name", name);
			req.setAttribute("pass", pw);
			req.setAttribute("email", email);
			req.setAttribute("code", code);
		} else if (req.getParameter("id").equals("project")) {
			req.setAttribute("which", "project");
			req.setAttribute("name", name);
			Project p = controller_prj.get_project((String)req.getSession().getAttribute("project_title"));
			req.setAttribute("title", p.get_title());
			req.setAttribute("desc", p.get_description());
			req.setAttribute("file_name", p.get_file_name());
			req.setAttribute("date", p.get_date());
		} else if (req.getParameter("id").equals("faculty")) {
			Faculty f = controller_one_f.get_faculty(name);
			fac_title = f.get_title();
			System.out.println("title :" + fac_title);
			fac_desc = f.get_description();
			System.out.println("desc: " + fac_desc);
			interest = f.get_interest();
			System.out.println("interest: " + interest);
			file_name = f.get_file_name();
			
			req.setAttribute("name", name);
			req.setAttribute("pass", pw);
			req.setAttribute("email", email);
			req.setAttribute("title", fac_title);
			req.setAttribute("desc", desc);
			req.setAttribute("interest", interest);
			req.setAttribute("fac_code", code);
			req.setAttribute("file_name", file_name);
		}
		req.setAttribute("errorMessage", errorMessage);

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
		String old_title		= null;
		old_name = (String) req.getSession().getAttribute("user");
		old_pw = (String) req.getSession().getAttribute("pw");
		old_email = (String) req.getSession().getAttribute("email");
		old_title = (String) req.getSession().getAttribute("project_title");
		
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
			String new_desc = null;
			String new_interest = null;
			String new_title = null;
			String file_name = null;
			Boolean valid = true;
			
			new_name = (String) req.getParameter("new_name");
			new_pass = (String) req.getParameter("new_password");
			new_pass2 = (String) req.getParameter("new_password2");
			new_email = (String) req.getParameter("new_email");
			new_fac_code = (String) req.getParameter("new_fac_code");
			new_desc = (String) req.getParameter("new_fac_description");
			new_title = (String) req.getParameter("new_fac_title");
			new_interest = (String) req.getParameter("new_fac_interest");
			System.out.println("new_name: " + new_name + ", new pass: " + new_pass + ", new email: " + new_email + ", new code: " + new_fac_code);
			InputStream inputStream = null; // input stream of the upload file
	        
	        // obtains the upload file part in this multipart request
	        Part filePart = req.getPart("image");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            file_name = filePart.getSubmittedFileName();
	        } else { 
	        	System.out.println("part was null <-- this means there was an error w/ the pic"); 
	        	errorMessage = "Picture format is invalid, please try again";
	        }
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
				controller.UpdateFaculty(new_email, old_name, new_pass, new_name, new_fac_code, new_desc, new_interest, new_title, inputStream, file_name);
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
			
		} else if (req.getSession().getAttribute("type").equals("student") && req.getSession().getAttribute("project_title") != null) {
			String title = null;
			String desc = null;
			String date = null;
			String file_name = null;
			String errorMessage = null;
			Boolean valid = true;
			InputStream inputStream = null; // input stream of the upload file
			Part filePart = req.getPart("new_image");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            file_name = filePart.getSubmittedFileName();
	        } else { 
	        	System.out.println("part was null <-- this means there was an error w/ the pic"); 
	        	errorMessage = "Please select a file for your abstract";
	        }
	        
	        // now we set the parameters from our jsp into the ones we declared null (input stream and filename are already set)
	        title = req.getParameter("new_title");
	        desc = req.getParameter("new_desc");
	        date = req.getParameter("new_date");
	        
	        System.out.println("new_title: " + title + ", new desc: " + desc + ", new date: " + date);
	        
			try {
				if (title == null || title.equals("") || desc== null || desc.equals("") || date == null || date.equals("")) {
					errorMessage = "Please enter all fields";
					System.out.println("something was null or empty");
					valid = false;
				}
			} catch (NullPointerException e) {}
			if (valid) {
				System.out.println("Updating project...");
				controller_upd_prj.UpdateProject(old_title, title, desc, date, inputStream, file_name);
				resp.sendRedirect(req.getContextPath() + "/MyAccount");
			} else {
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("new_title", title);
				req.setAttribute("new_desc", desc);
				req.setAttribute("new_date", date);
				req.getRequestDispatcher("/_view/Update.jsp").forward(req, resp);
			}
	
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
			// now check for valid input (nothing is empty)

			
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
