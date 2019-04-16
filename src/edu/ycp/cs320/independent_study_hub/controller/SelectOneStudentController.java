package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class SelectOneStudentController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public SelectOneStudentController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/**
	 * selects on student based on the name
	 * @acc_name is the name of the acc we are looking for
	 * @return returns a single student object
	 */
	public Student get_student(String acc_name) {
		Student s = new Student();
		s = db.get_student(acc_name);
		return s;	
	}
}
