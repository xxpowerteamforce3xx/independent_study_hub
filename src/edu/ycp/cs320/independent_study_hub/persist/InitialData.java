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
	public static List<PreviousWork> getPreviousWork() {
		ArrayList<PreviousWork> previousWorkList = new ArrayList<PreviousWork>();
		PreviousWork previous = new PreviousWork("Cole Rohrbaugh", "Lipid Extraction from Bee Pollen", "Extraction of lipids from bee pollen. Characterization of lipids using HPLC", 2019);
		previousWorkList.add(previous);
		return previousWorkList;
	}
	public static List<ChemicalInventory> getChemicals() {
		ArrayList<ChemicalInventory> chemicalList = new ArrayList<ChemicalInventory>();
		ChemicalInventory chemical = new ChemicalInventory(1, "Stearic Acid", "Research", 2019);
		chemicalList.add(chemical);
		return chemicalList;
		/*List<ChemicalInventory> chemicalList = new ArrayList<ChemicalInventory>();
		ReadCSV readChemcials = new ReadCSV("chemicals.csv");
		try {
			// auto-generated primary key for authors table
			Integer chemicalID = 1;
			Integer dom = 2019;
			while (true) {
				List<String> tuple = readChemcials.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				ChemicalInventory chemical = new ChemicalInventory();
				chemical.setChemicalID(chemicalID++);				
				chemical.setChemical(i.next());
				chemical.setUseOfChemcial(Integer.parseInt(i.next()));
				chemical.setDom(Integer.parseInt(i.next()));
				chemicalList.add(chemical);
			}
			return chemicalList;
		} finally {
			readChemcials.close();
		}*/
	}
}
