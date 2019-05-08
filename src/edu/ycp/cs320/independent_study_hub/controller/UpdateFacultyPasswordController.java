package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.io.InputStream;
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
public class UpdateFacultyPasswordController {
	private IDatabase db = null;
	
	public UpdateFacultyPasswordController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	public boolean UpdateFacultyPassword (final String email, final String old_name, final String pw, final String new_name, final String fac_code) {
		boolean b = db.update_faculty_password_recovery(email, old_name, pw, new_name, fac_code);
		if (b) {
			System.out.println("Updated Faculty!");
			return true;
		} 
		
		return false;
	}
}
