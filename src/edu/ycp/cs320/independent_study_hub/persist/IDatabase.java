package edu.ycp.cs320.independent_study_hub.persist;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.user_models.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.user_models.PreviousWork;
import edu.ycp.cs320.independent_study_hub.user_models.User;

public interface IDatabase {
	public ArrayList<User> get_user(String acc_name, int acc_type);
	public ArrayList<ChemicalInventory> insertChemical(int chemicalID, String chemical, String use, int dom);
	public ArrayList<ChemicalInventory> getChemicals(int dom);
	public ArrayList<PreviousWork> getWorkFromYear(int year);
	public ArrayList<PreviousWork> insertPreviousWork(String name, String title, String description, int year);
}
