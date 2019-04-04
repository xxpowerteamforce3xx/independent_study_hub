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
	private int workID;
	
	/**
	 * 
	 * @param title	--> title of proj
	 * @param student --> student associated with project
	 * @param date -->  date added into inventory
	 * @param desc --> general description, can be a paragraph, 
	 * @param image --> not sure about this one, java has this as a data type so lets roll with it
	 * @param workID --> type of work
	 */
	public Project(String title, Student student, int year, String desc, JPEG image, int workID) {
		this.title = title;
		this.student = student;
		this.year = year;
		this.description = desc;
		this.image = image;
		this.workID = workID;
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
	
	public int get_id() {
		return workID;
	}
	
	// setters if the user wants to edit their projects
	
	public void set_title(String title) {
		this.title = title;
	}
	
	// we are skipping set student since that can never change
	
	public void set_year(int year) {
		this.year = year;
	}
	
	public void set_description(String desc) {
		description = desc;
	}
	
	public void set_jpeg(JPEG image) {
		this.image = image;
	}
	
	public void set_id(int id) {
		workID = id;
	}
	
}
