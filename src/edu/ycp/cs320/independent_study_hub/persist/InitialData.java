package edu.ycp.cs320.independent_study_hub.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class InitialData {
	
	/**
	 * populates our list of student users with init data
	 * @return the list of students
	 * @throws IOException 
	 */
	public static ArrayList<Student> get_student_users() throws IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		ReadCSV readStudentlist = new ReadCSV("students.csv");
		try {
			// auto-generated primary key for authors table
			
			while (true) {
				List<String> tuple = readStudentlist.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Student students = new Student();
				students.setName(i.next());
				students.setPassword(i.next());
				students.setEmail(i.next());
				students.setType(Integer.parseInt(i.next()));
				studentList.add(students);
			}
			return studentList;
		} finally {
			readStudentlist.close();
		}
	}
	
	public static ArrayList<Faculty> get_faculty_users() throws IOException {
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		ReadCSV readFacultyList = new ReadCSV("faculty.csv");
		try {
			// auto-generated primary key for authors table
			
			while (true) {
				List<String> tuple = readFacultyList.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Faculty faculty = new Faculty();
				faculty.setName(i.next());
				faculty.setPassword(i.next());
				faculty.setEmail(i.next());
				faculty.setType(Integer.parseInt(i.next()));
				facultyList.add(faculty);
			}
			return facultyList;
		} finally {
			readFacultyList.close();
		}
	}
	public static List<Project> getProjects() throws IOException {
		List<Project> previousWorkList = new ArrayList<Project>();
		ReadCSV readPreviousWork = new ReadCSV("previousWork.csv");
		try {
			// auto-generated primary key for authors table
			Integer workID = 1;
			
			while (true) {
				List<String> tuple = readPreviousWork.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
								
				Student student = new Student();
				student.setName(i.next());	// student
				String title = i.next();						// title
				String desc = i.next();							// descr	
				int year = Integer.parseInt(i.next());			// year
				
				// constructor to create the new object
				Project oldWork = new Project(student, title, year, desc, null);	// jpeg field is null
				workID++;										// increment id
				previousWorkList.add(oldWork);
			}
			return previousWorkList;
		} finally {
			readPreviousWork.close();
		}
	}
	public static List<ChemicalInventory> getChemicals() throws IOException {
		List<ChemicalInventory> chemicalList = new ArrayList<ChemicalInventory>();
		ReadCSV readChemcials = new ReadCSV("chemicals.csv");
	
		try {
			// auto-generated primary key for authors table
			Integer chemicalID = 1;
			
			while (true) {
				List<String> tuple = readChemcials.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				ChemicalInventory chemical = new ChemicalInventory();
				chemical.setChemicalID(chemicalID++);				
				chemical.setChemical(i.next());
				chemical.setUseOfChemcial(i.next());
				chemical.setDom(Integer.parseInt(i.next()));
				chemicalList.add(chemical);
			}
			return chemicalList;
		} finally {
			readChemcials.close();
		}
	}
}
