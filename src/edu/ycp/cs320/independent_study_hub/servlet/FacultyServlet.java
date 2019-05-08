package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.SelectAllFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;

public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		
		//The list that will store all faculty members from the database that our controller returns
		ArrayList<Faculty> faculty = null;
		
		//Controller that will retrieve all faculty data in the form of an array list of references to faculty objects
		SelectAllFacultyController controller = new SelectAllFacultyController();
		
		
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		req.setAttribute("user", user);
		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");
		
		
		System.out.println("Faculty Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		
		
		//Call for our array list of faculty member objects
		faculty = controller.get_all_faculty();
		
		//Sets "faculty" attribute in HTTP servlet request to our array list
		req.setAttribute("faculty", faculty);
		
		//Passes HTTP request and response to JSP to insert array list
		req.getRequestDispatcher("/_view/faculty.jsp").forward(req, resp);
		
		req.getRequestDispatcher("/_view/faculty.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Faculty servlet doPost");
		System.out.println(req.getSession().getAttribute("user"));
		
		
		String user = (String) req.getSession().getAttribute("user");
		req.setAttribute("user", user);
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		
		String logout = null;
		logout = req.getParameter("leave");
		if (logout.equals("Log out")) {
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/Login");
		}
		
	}
	
	
}
