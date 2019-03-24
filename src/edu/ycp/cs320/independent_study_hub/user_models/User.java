package edu.ycp.cs320.independent_study_hub.user_models;

public abstract class User {
	
	
	/**
	 * getter for the password
	 * @return a string password associated with the user
	 */
	public abstract String get_password();
	
	/**
	 * sets the current password to the one specified in the parameter
	 * @param pass is the new password to be changed to
	 */
	public abstract void change_password(String pass);

	/**
	 * getter for the name of the user
	 * @return a string name
	 */
	public abstract String get_name();
	
	/**
	 * getter for the email of the user
	 * @return a string email
	 */
	public abstract String get_email();
	
	/**
	 * gets the type of account (0 = guest, 1 = student, 2 = faculty)
	 * @return the int associated with the type of account
	 */
	public abstract int get_type();
	
	
}
