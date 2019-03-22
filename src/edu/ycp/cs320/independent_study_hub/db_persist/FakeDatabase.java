package edu.ycp.cs320.independent_study_hub.db_persist;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.c320.independent_study_hub.db_user_models.Faculty;
import edu.ycp.c320.independent_study_hub.db_user_models.Guest;
import edu.ycp.c320.independent_study_hub.db_user_models.Student;
import edu.ycp.c320.independent_study_hub.db_user_models.User;

public class FakeDatabase implements IDatabase {
	
	private List<Guest> guest_list;
	private List<Student> student_list;
	private List<Faculty> faculty_list;
	
	public FakeDatabase() {
		guest_list = new ArrayList<Guest>();
		student_list = new ArrayList<Student>();
		faculty_list = new ArrayList<Faculty>();
		
		// Add initial data from all of our lists
		readInitialData();
		
		// print out init sizes to see if init data class worked (hopefully)
		System.out.println("init size of guest_list: " + guest_list.size());
		System.out.println("init size of student_list: " + student_list.size());
		System.out.println("init size of faculty_list: " + faculty_list.size());
	}
	
	/**
	 * gets the init data from our hard coded user list
	 */
	public void readInitialData() {
			guest_list.addAll(InitialData.get_guest_users());
			student_list.addAll(InitialData.get_student_users());
			faculty_list.addAll(InitialData.get_faculty_users());
	}
	
// #########################################################################################################
// 								now for all of our fake database methods
// #########################################################################################################
	
	@Override
	/**
	 * returns a single acc based on the name, and the type of acc we want
	 */
	public ArrayList<User> get_user(String acc_name, int acc_type) {
		ArrayList<User> result = new ArrayList<User>();
		// basic fields we will populate if they should be returned
	
		System.out.println(acc_type);
		
		// first we need to figure out the type of acc we want
		if (acc_type == 0) {	// it is a guest acc
			for (Guest guest : guest_list) {
				if (guest.get_name() == acc_name) {
					result.add(guest);
				}
			}
		} else if (acc_type == 1) {		// it is a student acc
			for (Student student : student_list) {
				if (student.get_name() == acc_name) {
					result.add(student);
				}
			}
		} else if (acc_type == 2) {		// it is a fac acc
			for (Faculty faculty: faculty_list) {
				if (faculty.get_name() == acc_name) {
					result.add(faculty);
				}
			}
		}
		
		// if none of those hit, then something went wrong (oops)
		//System.out.println("yeet my guy, nothing came up. just WHO are you lookin for?");
		return result;
	}
	
}