package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
public class SelectStudentsByFacCodeController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me, im going to for 10,000,000
	 */
	public SelectStudentsByFacCodeController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	

	public ArrayList<Student> SelectStudentByFacCode(String code) {
		
		ArrayList<Student> s_list = db.selectStudentsByFacCode(code);
		System.out.println(s_list.size());
		// check if anything was returned and output the list
		if (s_list.isEmpty()) {
			System.out.println("No students signed up with code " + code);
			return null;
		} else {
			for (Student s: s_list) {
				System.out.println(s.getID() + "| " + s.get_name() + ", " + s.get_password() + ", " + s.get_email() + ", " + s.get_faculty_code());
			}
			return s_list;
		}
	}
}
