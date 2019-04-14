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
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class GetWorkFromYearController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public GetWorkFromYearController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/**
	 * gets a list of projects from a year specified
	 * @param year --> the year we are looking for
	 * @return --> a list of projects from the year
	 */
	public List<Project> GetWorkFromYear (int year) {
		
		List<Project> previousList = db.getWorkFromYear(year);
		
		// check if anything was returned and output the list
		if (previousList.isEmpty()) {
			//System.out.println("No research found with in <" + year + ">");
			return null;
		} else {
			for (Project previous: previousList) {
				Student s = previous.get_student();
				System.out.println(previous.get_s_id() + " , " + s.get_name() + ", " + previous.get_title() + ", " + previous.get_description() + ", " + previous.get_year());
			}
			return previousList;
		}
	}
}
