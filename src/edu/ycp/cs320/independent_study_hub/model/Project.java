package edu.ycp.cs320.independent_study_hub.model;



import com.sun.imageio.plugins.jpeg.JPEG;

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
	private int year;		
	private String description;	
	private JPEG image;			
	private int p_id;
	private int s_id;
	private String date;

	public Project() {
		
	}
	
	// getters for private fields 
	
	public String get_title() {
		return title;
	}
	
	public Student get_student() {
		return student;
	}
	
	public int get_year() {
		return year;
	}
	
	public String get_description() {
		return description;
	}
	
	public JPEG get_jpeg() {
		return image;
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
	
	public void set_year(int year) {
		this.year = year;
	}
	
	public void set_description(String desc) {
		description = desc;
	}
	
	public void set_jpeg(JPEG image) {
		this.image = image;
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
	
}
