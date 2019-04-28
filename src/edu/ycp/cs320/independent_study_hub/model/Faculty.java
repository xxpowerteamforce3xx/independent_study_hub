package edu.ycp.cs320.independent_study_hub.model;

public class Faculty extends User {
	private int facultyID;
	private String password, username, email, img_url, title, interest, description;
	// type is set to 2 because this is a faculty account
	private int type = 2;
	
	/**
	 * constructor for the first time creation of a faculty type of user **NOTE: type is not allowed to be changed,
	 * will always be 2 for a faculty type user
	 * @param name = the name of the account being created
	 * @param password = the password of the account being created
	 * @param email = the email of the account being created
	 */
	public Faculty() {
	
	}
	
	// methods below are from the abstract user class, documentation is there
	
	public int getID() {
		return facultyID;
	}
	
	@Override 
	public void setID(int facultyID) {
		this.facultyID = facultyID;
	}
	
	@Override
	public String get_password() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void change_password(String pass) {
		this.password = pass;	
	}
	
	@Override
	public String get_name() {
		return username;
	}
	
	@Override 
	public void setName(String name) {
		this.username = name;
	}
	
	@Override
	public String get_email() {
		return email;
	}
	
	@Override 
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int get_type() {
		return type;
	}
	
	@Override 
	public void setType(int type) {
		this.type = type;
	}
	
	public String get_img() {
		return img_url;
	}
	
	public void setImg(String url) {
		this.img_url = url;
	}
	
	public String get_title() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String get_interest() {
		return interest;
	}
	
	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String get_description() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}





