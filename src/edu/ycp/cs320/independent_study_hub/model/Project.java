package edu.ycp.cs320.independent_study_hub.model;


/**
 * general class to be the model for students projects
 * previous work lists will consist of type project
 * student's personal pages will consist of project type objects
 * and a general jsp form to fill out a student project based on 
 * what kind of projects they have, how many they have, etc.
 * 
 * @author cole, lucas
 * 
 */
public class Project {
	private String title;		 
	private Student student;	
	private String description;	
	private byte[] image;			
	private int p_id;
	private int s_id;
	private String date;
	private String file_name;

	public Project() {
		
	}
	
	// getters for private fields 
	
	public String get_title() {
		return title;
	}
	
	public Student get_student() {
		return student;
	}

	
	public String get_description() {
		return description;
	}
	
	public byte[] get_image() {
		return image;
	}
	
	public void set_image(byte[] image) {
		this.image = image;
	}
	
	public int get_p_id() {
		return p_id;
	}
	
	public int get_s_id() {
		return s_id;
	}
	
	// setters if the user wants to edit their projects
	
	public void set_title(String title) {
		this.title = title;
	}
	
	public void set_student(Student s) {
		student = s;
	}
	
	
	public void set_description(String desc) {
		description = desc;
	}
	
	public void set_p_id(int id) {
		p_id = id;
	}
	
	public void set_s_id(int id) {
		s_id = id;
	}

	public void set_date(String date) {
		this.date = date;
	}

	public String get_date() {
		return date;
	}

	public void set_file_name(String file_name) {
		this.file_name = file_name;
		
	}
	
	public String get_file_name() {
		return file_name;
	}
	
}
