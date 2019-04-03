package edu.ycp.cs320.independent_study_hub.user_models;

public class Guest extends User {
	private int guestID;
	private String password = "password";
	private String name = "guest";
	// type is set to 0 because this is a guest account
	private int type = 0;
	
	/**
	 * constructor for the first time creation of a guest type of user **NOTE: type is not allowed to be changed,
	 * will always be 0 for a guest type user
	 * @param name = guest
	 * @param password = password
	 */
	public Guest() {

	}
	
	// methods below are from the abstract user class, documentation is there
	@Override
	public int getID() {
		return guestID;
	}

	@Override
	public String get_password() {
		return password;
	}

	@Override
	public String get_name() {
		return name;
	}


	@Override
	public int get_type() {
		return type;
	}

	@Override
	public void change_password(String pass) {
		
	}

	@Override
	public String get_email() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setID(int ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(int type) {
		// TODO Auto-generated method stub
		
	}

}
