package edu.ycp.cs320.independent_study_hub.user_models;

public class PreviousWork {
	private int workID;
	private String name;
	private String title;
	private String description;
	private int year;
	/**
	 * getter for the chemical
	 * @return a string chemical
	 */
	public PreviousWork() {

	}
	public int getWorkID() {
		return workID;
	}
	public void setWorkID(int workID) {
		this.workID = workID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	//use is 0 if class, 1 if research
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
