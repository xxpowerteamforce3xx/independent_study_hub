package edu.ycp.cs320.independent_study_hub.persist;

import java.util.ArrayList;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

public interface IDatabase {
	public boolean insertChemical(String chemical, String use, int dom);
	public ChemicalInventory get_chemical(String chemcial);
	public ArrayList<Project> getWorkFromYear(int year);
	public boolean insertProject(String title, Student student, int year, String description, JPEG image, int workID);
	public boolean insertStudent(String name, String password, String email);
	public boolean insertChemical(String chemical, String use, Integer amount);
	public boolean insertFaculty(String name, String password, String email);
	public Guest get_guest(String acc_name);
	public Student get_student(String acc_name);
	public Faculty get_faculty(String acc_name);
	public ArrayList<Student> get_all_students();
	public ArrayList<Faculty> get_all_faculty();
	public ArrayList<Project> get_all_projects();
	public ArrayList<ChemicalInventory> get_all_chemicals();
}
