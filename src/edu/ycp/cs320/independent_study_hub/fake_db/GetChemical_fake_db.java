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
		int dom = keyboard.nextInt();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<ChemicalInventory> chemicalList = db.getChemicals(dom);
		
		// check if anything was returned and output the list
		if (chemicalList.isEmpty()) {
			System.out.println("No chemicals found with this year: <" + dom + ">");
		}
		else {
			for (ChemicalInventory Chemical: chemicalList) {
				System.out.println(Chemical.getChemicalID() + ", " + Chemical.getChemical() + ", " + Chemical.getUseOfChemical() + "," + Chemical.getDom());
			}
		}
	}
}
