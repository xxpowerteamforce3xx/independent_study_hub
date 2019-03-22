package edu.ycp.c320.independent_study_hub.db_user_models;

public class Faculty extends User {
	private String password, name, email;
	// type is set to 2 because this is a faculty account
	private int type = 2;
	
	/**
	 * constructor for the first time creation of a faculty type of user **NOTE: type is not allowed to be changed,
	 * will always be 2 for a faculty type user
	 * @param name = the name of the account being created
	 * @param password = the password of the account being created
	 * @param email = the email of the account being created
	 */
	public Faculty(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	// methods below are from the abstract user class, documentation is there
	
	@Override
	String get_password() {
		return password;
	}

	@Override
	void change_password(String pass) {
		password = pass;
		
	}

	@Override
	String get_name() {
		return name;
	}
	
	@Override
	String get_email() {
		return email;
	}

	@Override
	int get_type() {
		return type;
	}
}
