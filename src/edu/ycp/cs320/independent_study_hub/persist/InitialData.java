package edu.ycp.cs320.independent_study_hub.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.independent_study_hub.user_models.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.user_models.Faculty;
import edu.ycp.cs320.independent_study_hub.user_models.Guest;
import edu.ycp.cs320.independent_study_hub.user_models.PreviousWork;
import edu.ycp.cs320.independent_study_hub.user_models.Student;
import edu.ycp.cs320.independent_study_hub.user_models.User;

public class InitialData {
	
	/**
	 * returns the single guest usuer
	 * @return a list of all guest users (only 1 right now)
	 * @throws IOException 
	 */
	public static ArrayList<Guest> get_guest_users() throws IOException {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		ReadCSV readGuestList = new ReadCSV("guests.csv");
		System.out.println("Test 1");
		try {
			// auto-generated primary key for authors table
			Integer guestID = 1;
			
			System.out.println("Test 2");
			while (true) {
				List<String> tuple = readGuestList.next();
				System.out.println("Test 3");
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Guest guests = new Guest();
				guests.setID(guestID++);
				guests.setName(i.next());
				guests.setPassword(i.next());
				guests.setEmail(i.next());
				guests.setType(Integer.parseInt(i.next()));
				guestList.add(guests);
				System.out.println("Test 5");
			}
			return guestList;
		} finally {
			readGuestList.close();
		}
	}
	
	/**
	 * populates our list of student users with init data
	 * @return the list of students
	 * @throws IOException 
	 */
	public static ArrayList<Student> get_student_users() throws IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		ReadCSV readStudentlist = new ReadCSV("students.csv");
		System.out.println("Test 1");
		try {
			// auto-generated primary key for authors table
			Integer studentID = 1;
			
			System.out.println("Test 2");
			while (true) {
				List<String> tuple = readStudentlist.next();
				System.out.println("Test 3");
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Student students = new Student();
				students.setID(studentID++);
				students.setName(i.next());
				students.setPassword(i.next());
				students.setEmail(i.next());
				students.setType(Integer.parseInt(i.next()));
				studentList.add(students);
				System.out.println("Test 5");
			}
			return studentList;
		} finally {
			readStudentlist.close();
		}
	}
	
	public static ArrayList<Faculty> get_faculty_users() throws IOException {
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		ReadCSV readFacultyList = new ReadCSV("faculty.csv");
		System.out.println("Test 1");
		try {
			// auto-generated primary key for authors table
			Integer facultyID = 1;
			
			System.out.println("Test 2");
			while (true) {
				List<String> tuple = readFacultyList.next();
				System.out.println("Test 3");
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Faculty faculty = new Faculty();
				faculty.setID(facultyID++);
				faculty.setName(i.next());
				faculty.setPassword(i.next());
				faculty.setEmail(i.next());
				faculty.setType(Integer.parseInt(i.next()));
				facultyList.add(faculty);
				System.out.println("Test 5");
			}
			return facultyList;
		} finally {
			readFacultyList.close();
		}
	}
	public static List<PreviousWork> getPreviousWork() throws IOException {
		List<PreviousWork> previousWorkList = new ArrayList<PreviousWork>();
		ReadCSV readPreviousWork = new ReadCSV("previousWork.csv");
		System.out.println("Test 1");
		try {
			// auto-generated primary key for authors table
			Integer workID = 1;
			
			System.out.println("Test 2");
			while (true) {
				List<String> tuple = readPreviousWork.next();
				System.out.println("Test 3");
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				PreviousWork oldWork = new PreviousWork();
				oldWork.setWorkID(workID++);
				oldWork.setName(i.next());
				oldWork.setTitle(i.next());
				oldWork.setDescription(i.next());
				oldWork.setYear(Integer.parseInt(i.next()));
				previousWorkList.add(oldWork);
				System.out.println("Test 5");
			}
			return previousWorkList;
		} finally {
			readPreviousWork.close();
		}
	}
	public static List<ChemicalInventory> getChemicals() throws IOException {
		List<ChemicalInventory> chemicalList = new ArrayList<ChemicalInventory>();
		ReadCSV readChemcials = new ReadCSV("chemicals.csv");
		System.out.println("Test 1");
		try {
			// auto-generated primary key for authors table
			Integer chemicalID = 1;
			
			System.out.println("Test 2");
			while (true) {
				List<String> tuple = readChemcials.next();
				System.out.println("Test 3");
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
				System.out.println("Test 5");
			}
			return chemicalList;
		} finally {
			readChemcials.close();
		}
	}
}
