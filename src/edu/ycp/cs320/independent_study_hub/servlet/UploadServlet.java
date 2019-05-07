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
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.model.Student;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
	maxFileSize = 1024 * 1024 * 5, 
	maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectOneStudentController controller_one_student = new SelectOneStudentController();
	private InsertProjectController controller_insert_project = new InsertProjectController();
	
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
		
		req.getRequestDispatcher("/_view/Upload.jsp").forward(req, resp);
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
		String t = null;
		String desc = null;
		String date = null;
		Boolean valid = true;
		Student s = controller_one_student.get_student(user);
		t = req.getParameter("t");
		desc = req.getParameter("desc");
		date = req.getParameter("date");
		System.out.println("student: " + s.get_name() + ", title: " + t + ", desc: " + desc + ", date: " + date);
		
		if (t == null || t.equals("") || desc == null || desc.equals(null) || date == null || date.equals("") || s.get_name() == null) {
			errorMessage = "Please fill out all fields";
			valid = false;
		}
		// upload directory
		/*System.out.println(getServletContext().getRealPath("") + File.separator + "_view" + File.separator +"style");
		String uploadPath = getServletContext().getRealPath("") + File.separator + "_view" + File.separator +"style";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();*/
		
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
        } else { System.out.println("part was null <-- this means there was an error w/ the pic"); }
        
		if (valid) {
			System.out.println("date in servlet " + date);
			controller_insert_project.insertProject(s.get_name(), t, date, desc, inputStream);
			resp.sendRedirect(req.getContextPath() + "/MyAccount");
		}
		req.setAttribute("title", t);
		req.setAttribute("desc", desc);
		req.setAttribute("date", date);
		req.setAttribute("errorMessage", errorMessage);
		req.getRequestDispatcher("/_view/Upload.jsp").forward(req, resp);
	}
	
	
}
