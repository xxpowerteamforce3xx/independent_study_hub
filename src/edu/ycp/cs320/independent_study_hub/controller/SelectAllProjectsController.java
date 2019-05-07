package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
public class SelectAllProjectsController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public SelectAllProjectsController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/** 										* yeet *
	 * gets the list of chemicals from the year wanted
	 * @param dom --> the year looking for
	 * @return true if found, false for not found
	 */
	public ArrayList<Project> get_all_projects() {
		ArrayList<Project> prj_list = new ArrayList<Project>();
		prj_list = db.get_all_projects();
		System.out.println("Printing....\n ");
		System.out.println("Projects:");
		for (Project p : prj_list) {
			System.out.println(p.get_p_id() + "| " + p.get_s_id() + "| "+ p.get_student().get_name() + ", " + p.get_title() + ", " + p.get_date() + ", " + p.get_description());
		}
		System.out.println("\nPrint Complete");
		return prj_list;	
	}
}
