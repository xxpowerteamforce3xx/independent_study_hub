package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;

public class SelectAllPendingFacultyController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public SelectAllPendingFacultyController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/** 										* yeet *
	 * gets the list of chemicals from the year wanted
	 * @param dom --> the year looking for
	 * @return true if found, false for not found
	 */
	public ArrayList<Faculty> get_all_pending_faculty() {
		ArrayList<Faculty> fac_list = new ArrayList<Faculty>();
		fac_list = db.get_all_pending_faculty();
		return fac_list;	
	}
}
