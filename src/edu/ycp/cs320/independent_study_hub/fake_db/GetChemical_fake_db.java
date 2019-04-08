package edu.ycp.cs320.independent_study_hub.fake_db;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class GetChemical_fake_db {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase_fake_db.init(keyboard);

		System.out.print("Enter the year of the chemcial wanted: ");
		String name = keyboard.nextLine();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		ChemicalInventory chemical = db.getChemicals(name);
		System.out.println(chemical.getChemicalID() + ", " + chemical.getChemical() + ", " + chemical.getUseOfChemical() + "," + chemical.getDom());
		
	}
}
