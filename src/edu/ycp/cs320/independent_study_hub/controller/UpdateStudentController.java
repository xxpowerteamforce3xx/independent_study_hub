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
public class UpdateStudentController {
	private IDatabase db = null;
	
	public UpdateStudentController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	public boolean UpdateStudent (String email, String old_name, String pass, String new_name) {
		boolean b = db.update_student(email, old_name, pass, new_name);
		if (b) {
			System.out.println("Updated Student!");
			return true;
		} 
		
		return false;
	}
}
