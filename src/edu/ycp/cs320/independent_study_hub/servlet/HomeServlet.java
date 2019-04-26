package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		
		String user = (String) req.getSession().getAttribute("user");
		req.setAttribute("user", user);
		
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}

		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");
		
		System.out.println("Home Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		
		req.getRequestDispatcher("/_view/Home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		
		System.out.println("Home servlet do post");
		String logout = null;
		logout = req.getParameter("leave");
		if (logout.equals("Log out")) {
			req.getSession().setAttribute("user", null);
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/Login");
		}
	}
	
}
