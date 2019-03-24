package edu.ycp.cs320.independent_study_hub.user_models;

public class Student extends User {
	private String password, name, email;
	// type is set to 1 because this is a student type account
	private int type = 1;
	
	/**
	 * constructor for the first time creation of a student type of user **NOTE: type is not allowed to be changed,
	 * will always be 1 for a student type account
	 * @param name = the name of the account being created
	 * @param password = the password of the account being created
	 * @param email = the email of the account being created
	 */
	public Student(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	// methods below are from the abstract user class, documentation is there
	
	@Override
	public String get_password() {
		return password;
	}

	@Override
	public void change_password(String pass) {
		password = pass;
		
	}

	@Override
	public String get_name() {
		return name;
	}
	
	@Override
	public String get_email() {
		return email;
	}

	@Override
	public int get_type() {
		return type;
	}
}
