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
public class DeletePendingFacultyController {
	private IDatabase db = null;
	
	public DeletePendingFacultyController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	public boolean deletePendingFaculty (String name) {
		boolean b = db.deletePendingFaculty(name);
		if (b) {
			System.out.println("deleted <"+name+"> from db");
			return true;
		} 
		
		return false;
	}
}
