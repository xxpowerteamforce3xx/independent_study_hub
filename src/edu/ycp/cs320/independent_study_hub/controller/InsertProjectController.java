package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.model.User;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class InsertProjectController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public InsertProjectController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/**
	 * inserts a project into the db
	 * @param username --> username of student acc we are looking for
	 * @param title --> title of new project
	 * @param date --> year of new project
	 * @param description --> desc of new project
	 * @param image --> image (if available) of poster/project
	 * @param invalid --> id associated
	 * @return true if succesfull, false if not
	 */
	public boolean insertProject (String username, String title, String date, String description) {
		Student student = db.get_student(username);
		if (student != null) {
			Boolean b = db.insertProject(title, student, date, description);
			
			if (b) {
				return b;
			} else {
				System.out.println("Something went wrong, could not insert project with exisitng student");
			}
		} else {
			System.out.println("<" + username + "> was not found as an existing students username. Please create an account.");
		}
		return false;
	}
}
