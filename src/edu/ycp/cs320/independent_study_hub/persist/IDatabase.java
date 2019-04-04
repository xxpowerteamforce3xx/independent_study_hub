package edu.ycp.cs320.independent_study_hub.persist;

import java.util.ArrayList;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

public interface IDatabase {
	public ArrayList<ChemicalInventory> insertChemical(String chemical, String use, int dom);
	public ArrayList<ChemicalInventory> getChemicals(int dom);
	public ArrayList<Project> getWorkFromYear(int year);
	public ArrayList<Project> insertProject(String title, Student student, int year, String description, JPEG image, int workID);
	public Guest get_guest(String acc_name);
	public Student get_student(String acc_name);
	public Faculty get_faculty(String acc_name);
}
