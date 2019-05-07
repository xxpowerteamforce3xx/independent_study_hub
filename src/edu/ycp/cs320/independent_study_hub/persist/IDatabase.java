package edu.ycp.cs320.independent_study_hub.persist;

import java.io.InputStream;
import java.util.ArrayList;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

public interface IDatabase {
	public boolean insertChemical(String chemical, String use, String dom, int amount, String media);
	public ChemicalInventory get_chemical(String chemcial);
	public ArrayList<Project> getWorkFromYear(int year);
	public ArrayList<Project> selectProjectsByStudent(String name);
	public ArrayList<Student> selectStudentsByFacCode(String code);
	public boolean insertProject(String title, Student student, String date, String description, InputStream inputStream);
	public boolean insertStudent(String name, String password, String email);
	public boolean insertChemical(String chemical, String use, Integer amount);
	public boolean insertFaculty(String name, String password, String email);
	public boolean insertPendingFaculty(String name, String password, String email);
	public boolean deletePendingFaculty(String name);
	public Guest get_guest(String acc_name);
	public Student get_student(String acc_name);
	public Faculty get_faculty(String acc_name);
	public Project get_project(String title);
	public ArrayList<Student> get_all_students();
	public ArrayList<Faculty> get_all_faculty();
	public ArrayList<Faculty> get_all_pending_faculty();
	public ArrayList<Project> get_all_projects();
	public ArrayList<ChemicalInventory> get_all_chemicals();
	Faculty get_faculty_id(String acc_name);
	boolean update_faculty(String email, String old_name, String pass, String new_name, String fac_code);
	boolean update_student(String email, String old_name, String pass, String new_name);
	public boolean deleteChemical(String chemical, String use, String dom, int amount, String media);
}
