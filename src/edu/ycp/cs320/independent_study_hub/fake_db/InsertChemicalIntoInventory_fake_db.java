package edu.ycp.cs320.independent_study_hub.fake_db;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class InsertChemicalIntoInventory_fake_db {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase_fake_db.init(keyboard);
		System.out.print("Enter the chemical name: ");
		String Chemical = keyboard.nextLine();
		System.out.print("Enter the use of the chemical (class or research): ");
		String use = keyboard.nextLine();
		System.out.print("Enter the year the chemical was purhcased: ");
		int dom = keyboard.nextInt();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<ChemicalInventory> chemicalList = db.insertChemical(Chemical, use, dom);
		
		// check if anything was returned and output the list
		if (chemicalList.isEmpty()) {
			System.out.println("No chemical found with chemical name <" + Chemical + ">");
		}
		else {
			for (ChemicalInventory chemicals: chemicalList) {
				System.out.println(chemicals.getChemicalID() + "," + chemicals.getChemical() + "," + chemicals.getUseOfChemical() + "," + chemicals.getDom() );
			}
		}
	}
}
