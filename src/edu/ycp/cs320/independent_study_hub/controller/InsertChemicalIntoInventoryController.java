package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.model.User;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class InsertChemicalIntoInventoryController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public InsertChemicalIntoInventoryController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new FakeDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/**
	 * inserts a chemical into our database
	 * does not need to return a list because when we run the real sql commands, it will update our table off into 
	 * the distance. storing the result in a list is just the way were checking if it happened
	 * @param chemical --> chemical we want to insert
	 * @param use --> use of chemical
	 * @param dom --> year 
	 * @return true if succsefull, false if not
	 */
	public boolean insertChemical(String chemical, String use, int dom) {
		
		Boolean b = db.insertChemical(chemical, use, dom);
		// check if anything was returned and output the list
		if (!b) {
			System.out.println("No chemical found with chemical name <" + chemical + ">");
			return false;
		}
		else {
			System.out.println("Chemical was inserted!");
			return true;
		}
	}
}
