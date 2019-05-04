package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.DeleteChemicalController;
import edu.ycp.cs320.independent_study_hub.controller.InsertChemicalController;
import edu.ycp.cs320.independent_study_hub.controller.SelectAllChemicalsController;
import edu.ycp.cs320.independent_study_hub.controller.SelectOneFacultyController;
import edu.ycp.cs320.independent_study_hub.controller.SelectProjectsByStudentController;
import edu.ycp.cs320.independent_study_hub.controller.SelectStudentsByFacCodeController;
import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsertChemicalController controller = null;	
	private DeleteChemicalController deleteController = null;	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.


		//The list that will store all chemicals from the database that our controller returns
		ArrayList<ChemicalInventory> inventory = null;

		//Controller that will retrieve all chemical data in the form of an array list of references to ChemicalInventory objects
		SelectAllChemicalsController controller = new SelectAllChemicalsController();


		String user = (String) req.getSession().getAttribute("user");
		if (user == null){
			System.out.println("   User: <" + user + "> not logged in or session timed out");

			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		} else if (user == "guest") {
			System.out.println("guest user, not allowed to see this");
			resp.sendRedirect(req.getContextPath() + "/Home");
		}

		req.setAttribute("user", user);
		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");


		System.out.println("Inventory Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);

		//Call for our array list of ChemicalInventory objects
		inventory = controller.get_all_chemicals();

		//Sets "inventory" attribute in HTTP servlet request to our array list
		req.setAttribute("inventory", inventory);

		req.getRequestDispatcher("/_view/Inventory.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Inventory servlet doPost");
		System.out.println(req.getSession().getAttribute("user"));
		String type = (String) req.getSession().getAttribute("type");
		req.setAttribute("type", type);
		if (type == null) {
			System.out.println("   User: <" + type + "> not logged in or session timed out");

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
		}
		catch(NullPointerException e) {
			
		}
		///
		String errorMessage   		 = null;
		String successMessage 		 = null;
		String deleteErrorMessage    = null;
		String deleteSuccessMessage  = null;
		String chemical 			 = null;
		String use         			 = null;
		String year_purchased        = null;
		String deleteChemical 		 = null;
		String deleteUse         	 = null;
		String delete_year_purchased = null;
		//Integer bought = 0;
		chemical = req.getParameter("chemical");
		use = req.getParameter("use");
		year_purchased = req.getParameter("year_purchased");
		deleteChemical = req.getParameter("deleteChemical");
		deleteUse = req.getParameter("deleteUse");
		delete_year_purchased = req.getParameter("delete_year_purchased");
		
		if (chemical    == null || chemical.equals("") ||
				use     == null || use.equals("")  ||
				year_purchased == null || year_purchased.equals("")) {

			errorMessage = "Please fill in all of the required fields";
		} else {
			controller = new InsertChemicalController();

			// convert published to integer now that it is valid
			//bought = Integer.parseInt(year_purchased);

			// get list of books returned from query			
			if (controller.insertChemical(chemical, use, year_purchased)) {
				successMessage = chemical;
			}
			else {
				errorMessage = "Failed to insert chemical: " + chemical;					
			}
		}
		req.setAttribute("chemical", chemical);
		req.setAttribute("use", use);
		req.setAttribute("year_purchased", year_purchased);
		req.setAttribute("errorMessage",   errorMessage);
		req.setAttribute("successMessage", successMessage);
		if (deleteChemical    == null || deleteChemical.equals("") ||
				deleteUse     == null || deleteUse.equals("")  ||
				delete_year_purchased   == null || delete_year_purchased.equals("")) {

			errorMessage = "Please fill in all of the required fields";
		} else {
			deleteController = new DeleteChemicalController();

			// convert published to integer now that it is valid
			//bought = Integer.parseInt(year_purchased);

			// get list of books returned from query			
			if (deleteController.deleteChemical(deleteChemical, deleteUse, delete_year_purchased)) {
				successMessage = deleteChemical;
			}
			else {
				errorMessage = "Failed to delete chemical: " + deleteChemical;					
			}
		}
		req.setAttribute("deleteErrorMessage",   deleteErrorMessage);
		req.setAttribute("deleteSuccessMessage", deleteSuccessMessage);
		doGet(req, resp);
	}
}
