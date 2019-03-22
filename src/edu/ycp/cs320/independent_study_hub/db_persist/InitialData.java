package edu.ycp.cs320.independent_study_hub.db_persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import edu.ycp.c320.independent_study_hub.db_user_models.Faculty;
import edu.ycp.c320.independent_study_hub.db_user_models.Guest;
import edu.ycp.c320.independent_study_hub.db_user_models.Student;
import edu.ycp.c320.independent_study_hub.db_user_models.User;
import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;

public class InitialData {
	
	/**
	 * returns the single guest usuer
	 * @return a list of all guest users (only 1 right now)
	 */
	public static ArrayList<Guest> get_guest_users() {
		// list to put our other lists in		
		ArrayList<Guest> guest_list = new ArrayList<Guest>();
	
		// now to create a guest acc
		// guest fields do not matter, we only need 1 guest acc
		Guest guest = new Guest("guest", "password", "email");
		
		guest_list.add(guest);	//	guest will be our inital field 
		
		return guest_list;
	}
	
	/**
	 * populates our list of student users with init data
	 * @return the list of students
	 */
	public static ArrayList<Student> get_student_users() {
		ArrayList<Student> student_list = new ArrayList<Student>();
		
		// now to create some student acc
		Student student_ben = new Student("ben", "pinkpowerrangerXD", "ben@ycp.edu");
		Student student_cole = new Student("cole", "flowers69420", "cole@ycp.edu");
		Student student_lucas = new Student("lucas", "lucasisawesome420", "lgartrell@ycp.edu");
		
		student_list.add(student_ben);
		student_list.add(student_cole);	//	our initial student fields
		student_list.add(student_lucas);
		
		return student_list;
	}
	
	public static ArrayList<Faculty> get_faculty_users() {
		ArrayList<Faculty> faculty_list = new ArrayList<Faculty>();
		
		// now to create the faculty acc
		Faculty old_man = new Faculty("grandpa", "WW2", "old_man@ycp.edu");	
		faculty_list.add(old_man);		//	inital faculty fields (only one to be able to change the chem index)
		
		return faculty_list;
		
	}
	
}
