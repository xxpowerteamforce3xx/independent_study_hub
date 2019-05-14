package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.ResourceController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllFacultyController;
import edu.ycp.cs320.independent_study_hub.model.*;

public class ResourcesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceController controller = new ResourceController();
	private SelectAllFacultyController controller_all_fac = new SelectAllFacultyController();
	private ArrayList<Faculty> fac = new ArrayList<Faculty>();
	private ArrayList<ResourceBlock> list_f = new ArrayList<ResourceBlock>();
	private ArrayList<ResourceBlock> list_s = new ArrayList<ResourceBlock>();
	private ArrayList<ResourceBlock> list_temp = new ArrayList<ResourceBlock>();
	
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
		
		req.setAttribute("user", user);
		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");
		
		
		System.out.println("Resources Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		Boolean found = false;
		fac = controller_all_fac.get_all_faculty();
		list_temp = controller.get_all_resources();
		
		for (int x = 0; x < list_temp.size(); x ++) {
			found = false;
			for (int j = 0; j < fac.size(); j++) {
				if (list_temp.get(x).get_by().equals(fac.get(j).get_name())) {
					list_f.add(list_temp.get(x));
					found = true;
				}
			}
			if (found != true) {
				list_s.add(list_temp.get(x));
			}
		}
		
		req.setAttribute("type", req.getSession().getAttribute("user"));
		
		req.setAttribute("s_blocks", list_s);
		req.setAttribute("f_blocks", list_f);
		
		req.getRequestDispatcher("/_view/Resources.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Resources servlet doPost");
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
		try {
			if (logout.equals("Log out")) {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + "/Login");
			}
		} catch (NullPointerException e) {
			System.out.println("logout was null");
		}
		
		String upload = null;
		upload = req.getParameter("upload");
		
		try {
			if (upload != null) {
				System.out.println("upload button was pressed");
				System.out.println("redirecting to update student");
				resp.sendRedirect(req.getContextPath() + "/UploadCard");
			}
			
		} catch(NullPointerException e) {System.out.println("upload button was null");}
		
	}

	
}
