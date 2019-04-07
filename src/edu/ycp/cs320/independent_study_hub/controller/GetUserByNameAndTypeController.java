package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.model.User;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class GetUserByNameAndTypeController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public GetUserByNameAndTypeController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new FakeDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/**
	 * calls the 3 different get user fake db methods (eventually the real methods) and returns the user wanted
	 * right now just going by username
	 * @param acc_name --> username of acc we want
	 * @param acc_type --> 0 for guest, 1 for student, 2 for faculty
	 * @return the acc we are looking for, otherwise null
	 */
	public User GetUserByNameAndType (String acc_name, int acc_type) {
		
		if (acc_type == 0) {	
			Guest guest = db.get_guest(acc_name);
			//System.out.println(guest.get_name() + ", " + guest.get_password());
			return guest;

		} else if (acc_type == 1) {
			Student student = db.get_student(acc_name);
			//System.out.println(student.get_name() + ", " + student.get_password() + ", " + student.get_email());
			return student;
			
		} else if (acc_type == 2) {
			Faculty faculty = db.get_faculty(acc_name);
			//System.out.println(faculty.get_name() + ", " + faculty.get_password() + ", " + faculty.get_email());
			return faculty;
				
		} else {
			//System.out.println("No user was found with the name " + acc_name + " and type "+ acc_type);
			return null;
		}
	}
}
