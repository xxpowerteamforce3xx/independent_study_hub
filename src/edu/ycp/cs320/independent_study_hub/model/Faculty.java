package edu.ycp.cs320.independent_study_hub.model;

public class Faculty extends User {
	private int facultyID;
	private String password, username, email, title, interest, description, faculty_code, file_name;
    private byte[] image;	
	// type is set to 2 because this is a faculty account
	private int type = 2;
	
	public Faculty() {
	
	}
	
	// methods below are from the abstract user class, documentation is there
	
	public int getID() {
		return facultyID;
	}
	
	public void set_file_name(String file_name) {
		this.file_name = file_name;
		
	}
	
	public String get_file_name() {
		return file_name;
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
	
	public byte[] get_image() {
		return image;
	}
	
	public void set_image(byte[] image) {
		this.image = image;
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

	public void setFacultyCode(String code) {
		faculty_code = code;
	}
	
	public String get_fac_code() {
		return faculty_code;
	}
	
}





