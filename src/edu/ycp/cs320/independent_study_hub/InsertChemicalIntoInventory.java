package edu.ycp.cs320.independent_study_hub;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.user_models.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class InsertChemicalIntoInventory {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		System.out.print("Enter the chemical name: ");
		String Chemical = keyboard.nextLine();
		System.out.print("Enter the use of the chemical (class or research): ");
		String use = keyboard.nextLine();
		System.out.print("Enter the chemicalID: ");
		int chemicalID = keyboard.nextInt();
		System.out.print("Enter the year the chemical was purhcased: ");
		int dom = keyboard.nextInt();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<ChemicalInventory> chemicalList = db.insertChemical(chemicalID, Chemical, use, dom);
		
		// check if anything was returned and output the list
		if (chemicalList.isEmpty()) {
			System.out.println("No chemical found with chemical name <" + Chemical + ">");
		}
		else {
			for (ChemicalInventory chemicals: chemicalList) {
				System.out.println(chemicals.getChemicalID() + "," + chemicals.getChemical() + "," + chemicals.getUseOfChemical() + "," + chemicals.getDom() + "," );
			}
		}
	}
}
