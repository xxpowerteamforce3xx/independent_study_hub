package edu.ycp.cs320.independent_study_hub.controller;

import java.util.ArrayList;

//Needed to use Faculty and Student classes
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.model.User;

public class LoginController {
	private String username = null;
	private String password = null;
	private SelectAllFacultyController facController;
	private SelectAllStudentsController stuController;
	private SelectStudentController student;
	
	//Controller stores the username and password provided by the user. 
	//Also creates objects that will call SQL queries for getting faculty and students 
	public LoginController(String username, String password) {
		this.username = username;
		this.password = password;
		this.facController = new SelectAllFacultyController();
		this.stuController = new SelectAllStudentsController();
		this.student = new SelectStudentController();		
	}
	
	//Checks that user input a valid faculty or student login
	public <T extends User> T validateUser() {
		
		
		ArrayList<Faculty> faculty = facController.get_all_faculty(); //ArrayList of all faculty members
		ArrayList<Student> students = stuController.get_all_students(); //ArrayList of all student members
		
		for (Student s: students) {
			if (s.get_name().toLowerCase() == this.username.toLowerCase() && s.get_password() == this.password) {
				return (T) student.get_student(this.username); 
			}
		}
		return null;
	}
	
}
