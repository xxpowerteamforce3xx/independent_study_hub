package edu.ycp.cs320.independent_study_hub.user_models;

public class Guest extends User {
	private int guestID;
	private String password, name, email;
	// type is set to 0 because this is a guest account
	private int type = 0;
	
	/**
	 * constructor for the first time creation of a guest type of user **NOTE: type is not allowed to be changed,
	 * will always be 0 for a guest type user
	 * @param name = the name of the account being created
	 * @param password = the password of the account being created
	 * @param email = the email of the account being created
	 */
	public Guest() {

	}
	
	// methods below are from the abstract user class, documentation is there
	@Override
	public int getID() {
		return guestID;
	}
	@Override 
	public void setID(int guestID) {
		this.guestID = guestID;
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
		return name;
	}
	@Override 
	public void setName(String name) {
		this.name = name;
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
}
