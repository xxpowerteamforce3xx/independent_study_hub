package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ycp.cs320.independent_study_hub.controller.InsertProjectController;
import edu.ycp.cs320.independent_study_hub.controller.ResourceController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.model.Student;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
	maxFileSize = 1024 * 1024 * 5, 
	maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceController controller = new ResourceController();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		} else if (user == "guest") {
			System.out.println("guest user, not allowed to see this");
			resp.sendRedirect(req.getContextPath() + "/Home");
		}

		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");
		
		
		System.out.println("Upload Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		
		req.getRequestDispatcher("/_view/UploadCard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Upload servlet doPost");
		System.out.println(req.getSession().getAttribute("user"));
		
		String user = (String) req.getSession().getAttribute("user");
		req.setAttribute("user", user);
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		
		try {
			String logout = null;
			logout = req.getParameter("leave");
			if (logout.equals("Log out")) {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + "/Login");
			}
		} catch(NullPointerException e) {}
		
		String errorMessage = null;
		String link = null;
		String desc = null;
		Boolean valid = true;
		

		desc = req.getParameter("desc");
		link = req.getParameter("link");		
		if (link == null || link.equals("") || desc == null || desc.equals(null)) {
			System.out.println("desc: " + desc + "link: " + link);
			errorMessage = "Please fill out all fields";
			valid = false;
		}

		if (valid) {
			System.out.println("uploading card...  name: " + user + " link: " + link);
			controller.insertResource(link, desc, user);
			resp.sendRedirect(req.getContextPath() + "/Resources");
		}
		req.setAttribute("link", link);
		req.setAttribute("desc", desc);
		req.setAttribute("errorMessage", errorMessage);
		req.getRequestDispatcher("/_view/UploadCard.jsp").forward(req, resp);
	}
	
	
}
