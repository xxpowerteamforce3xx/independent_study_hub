package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
public class SelectProjectsByStudentController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me, im going to for 10,000,000
	 */
	public SelectProjectsByStudentController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	

	public List<Project> SelectProjectsByStudent(String name) {
		
		List<Project> previousList = db.selectProjectsByStudent(name);
		System.out.println(previousList.size());
		// check if anything was returned and output the list
		if (previousList.isEmpty()) {
			System.out.println("No project was found by " + name);
			return null;
		} else {
			for (Project previous: previousList) {
				System.out.println(previous.get_s_id() + " , " + previous.get_student().get_name() + ", " + previous.get_title() + ", " + previous.get_description() + ", " + previous.get_year());
			}
			return previousList;
		}
	}
}
