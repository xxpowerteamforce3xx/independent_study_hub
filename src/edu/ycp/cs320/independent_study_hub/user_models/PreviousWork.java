package edu.ycp.cs320.independent_study_hub.user_models;

public class PreviousWork {
	
	private String name;
	private String title;
	private String description;
	private int year;
	/**
	 * getter for the chemical
	 * @return a string chemical
	 */
	public PreviousWork(String name, String title, String description, int year) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.year = year;
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
