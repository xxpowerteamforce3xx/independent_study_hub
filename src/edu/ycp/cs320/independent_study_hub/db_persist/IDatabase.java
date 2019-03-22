package edu.ycp.cs320.independent_study_hub.db_persist;

import java.util.ArrayList;

import edu.ycp.c320.independent_study_hub.db_user_models.User;

public interface IDatabase {
	public ArrayList<User> get_user(String acc_name, int acc_type);
}
