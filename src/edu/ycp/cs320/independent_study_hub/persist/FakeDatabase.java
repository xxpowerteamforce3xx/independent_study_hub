package edu.ycp.cs320.independent_study_hub.persist;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.user_models.Faculty;
import edu.ycp.cs320.independent_study_hub.user_models.Guest;
import edu.ycp.cs320.independent_study_hub.user_models.Student;
public class FakeDatabase implements IDatabase {

	private List<Guest> guest_list;
	private List<Student> student_list;
	private List<Faculty> faculty_list;
	private List<ChemicalInventory> chemicalList;
	private List<Project> previousList;
	public FakeDatabase() {
		guest_list = new ArrayList<Guest>();
		student_list = new ArrayList<Student>();
		faculty_list = new ArrayList<Faculty>();
		chemicalList = new ArrayList<ChemicalInventory>();
		previousList = new ArrayList<Project>();
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
		try {
			//guest_list.addAll(InitialData.get_guest_users());
			student_list.addAll(InitialData.get_student_users());
			faculty_list.addAll(InitialData.get_faculty_users());
			previousList.addAll(InitialData.getProjects());
			chemicalList.addAll(InitialData.getChemicals());
		}
		catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}

	// #########################################################################################################
	// 								now for all of our fake database methods
	// #########################################################################################################
	@Override
	/**
	 * returns a chemical use based on the name
	 */
	public ArrayList<ChemicalInventory> insertChemical(String Chemical, String use, int dom) {
		ArrayList<ChemicalInventory> result = new ArrayList<ChemicalInventory>();
		ChemicalInventory chemicals = new ChemicalInventory();
		chemicals.setChemicalID(chemicalList.size() + 1);
		chemicals.setChemical(Chemical);
		chemicals.setDom(dom);
		chemicals.setUseOfChemcial(use);
		result.add(chemicals);
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
	public ArrayList<Project> getWorkFromYear(int year) {
		ArrayList<Project> result = new ArrayList<Project>();
		for (Project previous: previousList) {
			if (previous.get_year() == year) {
				result.add(previous);
			}
		}
		return result;
	}
	
	@Override
	/**
	 * inserts a project 
	 */
	public ArrayList<Project> insertProject(String title, Student student, int year, String description, JPEG image, int workID) {
		ArrayList<Project> result = new ArrayList<Project>();

		//constructor for projects
		Project previous = new Project(description, student, workID, description, image, workID);
		
		result.add(previous);
		return result;
	}
	
	/**
	 * just returns a guest element
	 */
	public Guest get_guest(String acc_name) {
		Guest result = new Guest();
		return result;
	}
	
	/**
	 * returns a single student reference, otherwise null
	 */
	public Student get_student(String acc_name) {
		Student result = null;
		// basic fields we will populate if they should be returned
	
		for (Student student : student_list) {
			if (student.get_name().equals(acc_name)) {
				result = student;
			}
		}
		return result;
	}

	/**
	 * returns a single faculty reference, otherwise null
	 */
	public Faculty get_faculty(String acc_name) {
		Faculty result = null;
		// basic fields we will populate if they should be returned
		for (Faculty faculty: faculty_list) {
			if (faculty.get_name().equals(acc_name)) {
				result= faculty;
			}
		}
		return result;
	}
}