package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.SelectAllProjectsController;
import edu.ycp.cs320.independent_study_hub.model.Project;

public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectAllProjectsController controller = new SelectAllProjectsController();
	private ArrayList<Project> p_list = new ArrayList<Project>();
	
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
		
		// now we do the p_list yo
		p_list = controller.get_all_projects();
		req.setAttribute("p_list", p_list);
		
		req.getRequestDispatcher("/_view/Research.jsp").forward(req, resp);
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
		String title = null;
		try {
			title = req.getParameter("title");
			if (title != null) {
				System.out.println(title);
				req.getSession().setAttribute("project_name", title);
				}
			} catch (NullPointerException e) {}
			
		}
		
	}
	
	
