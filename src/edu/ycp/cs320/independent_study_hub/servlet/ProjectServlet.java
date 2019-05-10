package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.GetProjectController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllProjectsController;

import edu.ycp.cs320.independent_study_hub.model.Project;

public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetProjectController controller = new GetProjectController();
	
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
		}

		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");
		
		
		System.out.println("Research Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		// getting the url parameter and passing it into our db to get our project
		String title = null;
		title = req.getParameter("title");
		System.out.println(title);
		if (title != null) {
			Project p = controller.get_project(title);
			System.out.println("title: " + p.get_title() + ", desc: " + p.get_description() + ", date: " + p.get_date());
			req.setAttribute("title", p.get_title()); //Project title
			req.setAttribute("desc", p.get_description()); //Project abstract
			req.setAttribute("date", p.get_date()); 
			req.setAttribute("file_name", p.get_file_name());
			req.setAttribute("name", p.get_student().get_name());
		} else {
			System.out.println("param did not pass through url, title was null");
		}
		
		req.getRequestDispatcher("/_view/Project.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Research servlet doPost");
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
		} catch (NullPointerException e) {}
		
		
	}
	
	
}
