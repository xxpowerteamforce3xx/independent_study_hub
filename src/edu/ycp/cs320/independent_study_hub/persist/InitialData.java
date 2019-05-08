package edu.ycp.cs320.independent_study_hub.persist;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Part;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.MD5;
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
				//Reads each value in from our string list and inserts them into the appropriate attribute of our student object
				Iterator<String> i = tuple.iterator();
				Student students = new Student();
				students.setName(i.next());
				String password = MD5.getMd5(i.next());
				students.setPassword(password);
				students.setEmail(i.next());
				students.set_faculty_code(i.next());
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
				//Reads each value in from our string list and inserts them into the appropriate attribute of our faculty object
				Iterator<String> i = tuple.iterator();
				Faculty faculty = new Faculty();
				faculty.setName(i.next());
				String password2 = MD5.getMd5(i.next());
				faculty.setPassword(password2);
				faculty.setEmail(i.next());
				faculty.setTitle(i.next());
				faculty.setInterest(i.next());
				faculty.setDescription(i.next());
				String code = i.next();
				faculty.setFacultyCode(code);

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
			Integer projectID = 1;
			while (true) {
				List<String> tuple = readPreviousWork.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
								
				Student student = new Student();
				student.setName(i.next());	// student
				
				// constructor to create the new object
				Project oldWork = new Project(); // jpeg field is null
				oldWork.set_p_id(projectID++);
				oldWork.set_student(student);
				oldWork.set_title(i.next());
				oldWork.set_description(i.next());
				oldWork.set_date(i.next());
				oldWork.set_s_id(Integer.parseInt(i.next()));
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
				chemical.setDom(i.next());
				chemical.setAmount(Integer.parseInt(i.next()));
				chemical.setMedia(i.next());
				chemicalList.add(chemical);
			}
			return chemicalList;
		} finally {
			readChemcials.close();
		}
	}
}
