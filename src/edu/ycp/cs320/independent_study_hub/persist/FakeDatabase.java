package edu.ycp.cs320.independent_study_hub.persist;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.independent_study_hub.user_models.Faculty;
import edu.ycp.cs320.independent_study_hub.user_models.Guest;
import edu.ycp.cs320.independent_study_hub.user_models.PreviousWork;
import edu.ycp.cs320.independent_study_hub.user_models.Student;
import edu.ycp.cs320.independent_study_hub.user_models.User;
import edu.ycp.cs320.independent_study_hub.user_models.ChemicalInventory;
public class FakeDatabase implements IDatabase {
	
	private List<Guest> guest_list;
	private List<Student> student_list;
	private List<Faculty> faculty_list;
	private List<ChemicalInventory> chemicalList;
	private List<PreviousWork> previousList;
	public FakeDatabase() {
		guest_list = new ArrayList<Guest>();
		student_list = new ArrayList<Student>();
		faculty_list = new ArrayList<Faculty>();
		chemicalList = new ArrayList<ChemicalInventory>();
		previousList = new ArrayList<PreviousWork>();
		// Add initial data from all of our lists
		readInitialData();
		
		// print out init sizes to see if init data class worked (hopefully)
		System.out.println("init size of guest_list: " + guest_list.size());
		System.out.println("init size of student_list: " + student_list.size());
		System.out.println("init size of faculty_list: " + faculty_list.size());
		System.out.println("init size of chemical_list: " + chemicalList.size());
		System.out.println("init size of previous_list: " + previousList.size());
	}
	
	/**
	 * gets the init data from our hard coded user list
	 */
	public void readInitialData() {
		guest_list.addAll(InitialData.get_guest_users());
		student_list.addAll(InitialData.get_student_users());
		faculty_list.addAll(InitialData.get_faculty_users());
		chemicalList.addAll(InitialData.getChemicals());
		previousList.addAll(InitialData.getPreviousWork());
		/*try {
		}
		catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}*/
	}
	
// #########################################################################################################
// 								now for all of our fake database methods
// #########################################################################################################
	@Override
	/**
	 * returns a chemical use based on the name
	 */
	public ArrayList<ChemicalInventory> insertChemical(int chemicalID, String Chemical, String use, int dom) {
		ArrayList<ChemicalInventory> result = new ArrayList<ChemicalInventory>();
		ChemicalInventory chemical = new ChemicalInventory(chemicalID, Chemical, use, dom);
		chemical.setChemical(Chemical);
		chemical.setDom(dom);
		chemical.setChemicalID(chemicalID);
		chemical.setUseOfChemcial(use);
		result.add(chemical);
		return result;
	}
	@Override
	/**
	 * returns a chemical use based on the name
	 */
	public ArrayList<ChemicalInventory> getChemicals(int dom) {
		ArrayList<ChemicalInventory> result = new ArrayList<ChemicalInventory>();
		for (ChemicalInventory chemical: chemicalList) {
			if (chemical.getDom() == dom) {
				result.add(chemical);
			}
		}
		return result;
	}
	@Override
	/**
	 * returns a previous years work use based on the year
	 */
	public ArrayList<PreviousWork> getWorkFromYear(int year) {
		ArrayList<PreviousWork> result = new ArrayList<PreviousWork>();
		for (PreviousWork previous: previousList) {
			if (previous.getYear() == year) {
				result.add(previous);
			}
		}
		return result;
	}
	@Override
	/**
	 * returns a previous years work use based on the year
	 */
	public ArrayList<PreviousWork> insertPreviousWork(String name, String title, String description, int year) {
		ArrayList<PreviousWork> result = new ArrayList<PreviousWork>();
		PreviousWork previous = new PreviousWork(name, title, description, year);
		previous.setName(name);
		previous.setTitle(title);
		previous.setDescription(description);
		previous.setYear(year);
		result.add(previous);
		return result;
	}
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