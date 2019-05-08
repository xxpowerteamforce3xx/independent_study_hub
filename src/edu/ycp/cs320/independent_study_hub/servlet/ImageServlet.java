package edu.ycp.cs320.independent_study_hub.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.GetProjectController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllProjectsController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Project;

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetProjectController controller = new GetProjectController();
	private SelectOneFacultyController controller_fac = new SelectOneFacultyController();	
	
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
		resp.setContentType("image/png");							// set our return type
		
		System.out.println("Image Servlet: doGet");
		String name_OR_title = req.getParameter("id");
		String type = req.getParameter("type");
		if (type.equals("p")) {
			Project p = controller.get_project(name_OR_title);		
			resp.getOutputStream().write(p.get_image()); // write it all together
		} else if (type.equals("f")) {
			Faculty f = controller_fac.get_faculty(name_OR_title);
			resp.getOutputStream().write(f.get_image());
		}
	}	
}
