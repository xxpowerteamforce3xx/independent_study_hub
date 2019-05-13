package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.independent_study_hub.model.*;
import edu.ycp.cs320.independent_study_hub.controller.DeletePendingFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.DeleteProjectController;
import edu.ycp.cs320.independent_study_hub.controller.InsertFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.InsertStudentController;
import edu.ycp.cs320.independent_study_hub.controller.ResourceController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllPendingFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllProjectsController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllStudentsController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectProjectsByStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectStudentsByFacCodeController;
import edu.ycp.cs320.independent_study_hub.controller.DeleteStudentController;

public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectProjectsByStudentController controller_projects = new SelectProjectsByStudentController();
	private SelectAllProjectsController controller_all_p = new SelectAllProjectsController();
	private SelectStudentsByFacCodeController controller_students = new SelectStudentsByFacCodeController();
	private SelectAllPendingFacultyController controller_pending_get = new SelectAllPendingFacultyController();
	private DeletePendingFacultyController controller_delete = new DeletePendingFacultyController();
	private DeleteProjectController controller_delete_prj = new DeleteProjectController();
	private SelectAllStudentsController controller_all_students = new SelectAllStudentsController();
	private SelectAllFacultyController controller_all_faculty = new SelectAllFacultyController();
	private SelectOneFacultyController controller_one_fac = new SelectOneFacultyController();
	private InsertFacultyController controller_insert = new InsertFacultyController();
	private DeleteStudentController controller_delete_s = new DeleteStudentController();
	private ResourceController controller_r = new ResourceController();
	private List<Project> p_list = new ArrayList<Project>();
	private ArrayList<Project> all_projects = new ArrayList<Project>();
	private ArrayList<Student> s_list = new ArrayList<Student>();
	private ArrayList<Student> all_students = new ArrayList<Student>();
	private ArrayList<Faculty> pending_list = new ArrayList<Faculty>();
	private ArrayList<Faculty> all_fac = new ArrayList<Faculty>();	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyAccount servlet doGet");
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
		try {
			boolean found = false;
			all_fac = controller_all_faculty.get_all_faculty();
			all_students = controller_all_students.get_all_students();
			ArrayList<ResourceBlock> list_temp = controller_r.get_all_resources();
			ArrayList<ResourceBlock> list_f= new ArrayList<ResourceBlock>();
			ArrayList<ResourceBlock> list_s = new ArrayList<ResourceBlock>();
			for (int x = 0; x < list_temp.size(); x ++) {
				for (int j = 0; j < all_fac.size(); j++) {
					found = false;
					if (list_temp.get(x).get_by() == all_fac.get(j).get_name()) {
						list_f.add(list_temp.get(x));
						found = true;
					}
				}
				if (found != true) {
					list_s.add(list_temp.get(x));
				}
			}
			
			if (type.equals("student")) {
				p_list = controller_projects.SelectProjectsByStudent(name);
				req.setAttribute("projects", p_list);
				req.setAttribute("block_list", list_s);
			} else if (type.equals("faculty")) {
				Faculty f = controller_one_fac.get_faculty(name);
				s_list = controller_students.SelectStudentByFacCode(f.get_fac_code());
				all_projects = controller_all_p.get_all_projects();
				
				pending_list = controller_pending_get.get_all_pending_faculty();
				
				req.setAttribute("block_list", list_f);
				req.setAttribute("pending", pending_list);
				req.setAttribute("students", s_list);
				req.setAttribute("all_students", all_students);
				req.setAttribute("all_fac", all_fac);
				req.setAttribute("all_projects", all_projects);
				req.setAttribute("fac_title", f.get_title());
				req.setAttribute("desc", f.get_description());
				req.setAttribute("interest", f.get_interest());
				req.setAttribute("file_name", f.get_file_name());
				
			}
		} catch(NullPointerException e) {}
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("name", name);
		req.setAttribute("pass", pw);
		req.setAttribute("email", email);
		req.setAttribute("code", code);
		req.setAttribute("type", type);
		
		
		req.getRequestDispatcher("/_view/MyAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("MyAccount servlet doPost");
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
		try {
			if (type.equals("student")) {
				p_list = controller_projects.SelectProjectsByStudent(name);
				req.setAttribute("projects", p_list);
			} else if (type.equals("faculty")) {
				Faculty f = controller_one_fac.get_faculty(name);
				s_list = controller_students.SelectStudentByFacCode(f.get_fac_code());
				all_students = controller_all_students.get_all_students();
				pending_list = controller_pending_get.get_all_pending_faculty();
				all_projects = controller_all_p.get_all_projects();
				req.setAttribute("pending", pending_list);
				req.setAttribute("students", s_list);
				req.setAttribute("all_students", all_students);
				req.setAttribute("all_projects", all_projects);
			}
		} catch(NullPointerException e) {}
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("name", name);
		req.setAttribute("pass", pw);
		req.setAttribute("email", email);
		req.setAttribute("code", code);
		req.setAttribute("type", type);
		
		// everyting below is new post stuff
		String back = null;
		String logout = null;
		String update_student = null;
		String update_project = null;
		String update_faculty = null;
		String delete = null;
		String delete_prj = null;
		String delete_students = null;
		String add = null;
		String[] to_add = req.getParameterValues("nerds");
		String[] prj_delete = req.getParameterValues("projects_to_delete");
		String[] students_to_delete = req.getParameterValues("bad_kids");
		ArrayList<String> pending_names = new ArrayList<String>();
		ArrayList<String> projects_to_delete = new ArrayList<String>();
		ArrayList<String> bad_kids_names	 = new ArrayList<String>();
		delete = req.getParameter("delete");
		delete_prj = req.getParameter("delete_prj");
		delete_students = req.getParameter("delete_students");
		add = req.getParameter("add");
		back = req.getParameter("account");
		logout = req.getParameter("logout");
		update_student = req.getParameter("update_student");
		update_project = req.getParameter("update_project");
		update_faculty = req.getParameter("update_faculty");

		try {
			for (int k = 0; k < to_add.length; k++) {
				pending_names.add(to_add[k]);
			}
			if (delete.equals("delete")) {
				System.out.println("delete button was pressed");
				
				for (int i = 0; i < pending_list.size(); i++) {
					
					for (int x = 0; x < pending_names.size(); x++) {
						if (pending_names.get(x).equals(pending_list.get(i).get_name())) {
							System.out.println("deleting: " + pending_list.get(i).get_name());
							controller_delete.deletePendingFaculty(pending_list.get(i).get_name());
							resp.sendRedirect(req.getContextPath() + "/MyAccount");
						}
					}
				}				
			}
		} catch (NullPointerException e) { System.out.println("delete pending was null");} 
		
		try {
			for (int k = 0; k < prj_delete.length; k++) {
				projects_to_delete.add(prj_delete[k]);
			}
			
			if (delete_prj.equals("delete")) {
				System.out.println("delete project button was pressed");
	
				for (int i = 0; i < all_projects.size(); i++) {
					System.out.println(all_projects.get(i).get_title());
					for (int x = 0; x < projects_to_delete.size(); x++) {
						if (projects_to_delete.get(x).equals(all_projects.get(i).get_title())) {
							System.out.println("deleting: " + all_projects.get(i).get_title());
							controller_delete_prj.deleteProject(all_projects.get(i).get_title());
							resp.sendRedirect(req.getContextPath() + "/MyAccount");
						}
					}	
				}				
			}
		} catch (NullPointerException e) {System.out.println("delete projects was null"); }
		
		try {
			for (int k = 0; k < students_to_delete.length; k++) {
				bad_kids_names.add(students_to_delete[k]);
			}
			
			if (delete_students.equals("delete")) {
				System.out.println("delete students button was pressed");
	
				for (int i = 0; i < all_students.size(); i++) {
					System.out.println(all_students.get(i).get_name());
					for (int x = 0; x < bad_kids_names.size(); x++) {
						if (bad_kids_names.get(x).equals(all_students.get(i).get_name())) {
							System.out.println("deleting: " + all_students.get(i).get_name());
							controller_delete_s.deleteStudent(all_students.get(i).get_name());
							resp.sendRedirect(req.getContextPath() + "/MyAccount");
						}
					}	
				}				
			}
		} catch (NullPointerException e) {System.out.println("delete students was null"); }
		
		try {
			if (add.equals("add")) {
				System.out.println("add button was pressed");
			for (int i = 0; i < pending_list.size(); i++) {
				System.out.println(pending_names.get(i) + "<-- check value");
					if (pending_names.get(i).equals(pending_list.get(i).get_name())) {
						System.out.println("inserting: " + pending_list.get(i).get_name());
						controller_insert.insertFaculty(pending_list.get(i).get_name(), pending_list.get(i).get_password(), pending_list.get(i).get_email());
						controller_delete.deletePendingFaculty(pending_list.get(i).get_name());
						resp.sendRedirect(req.getContextPath() + "/MyAccount");
					}
				}				
			}
		} catch (NullPointerException e) { System.out.println("add pending was null");} 
		
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
		try {
			if (update_student.equals("update")) {
				System.out.println("redirecting to update student");
				resp.sendRedirect(req.getContextPath() + "/Update?id=student");
			}
		} catch (NullPointerException e) {}
		try {
			if (update_project != null) {
				System.out.println("redirecting to update project");
				req.getSession().setAttribute("project_title", update_project);
				resp.sendRedirect(req.getContextPath() + "/Update?id=project");
			}
		} catch (NullPointerException e) {}
		try {
			if (update_faculty.equals("update")) {
				System.out.println("redirecting to update faculty");
				resp.sendRedirect(req.getContextPath() + "/Update?id=faculty");
			}
		} catch (NullPointerException e) {}
		req.getRequestDispatcher("/_view/MyAccount.jsp").forward(req, resp);
	}

}
