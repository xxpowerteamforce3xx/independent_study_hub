package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class GetChemicalsController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public GetChemicalsController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new FakeDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/** 										* yeet *
	 * gets the list of chemicals from the year wanted
	 * @param dom --> the year looking for
	 * @return true if found, false for not found
	 */
	public ArrayList<ChemicalInventory> GetChemicals (int dom) {
		ArrayList<ChemicalInventory> chemical_list = db.getChemicals(dom);
		if (chemical_list.isEmpty()) {
			System.out.println("No chemicals were found with this year <" + dom + ">" );
			return null;
		} else {
			for (ChemicalInventory Chemical: chemical_list) {
				System.out.println(Chemical.getChemicalID() + ", " + Chemical.getChemical() + ", " + Chemical.getUseOfChemical() + "," + Chemical.getDom());
			}
		return chemical_list;
		}
	}
}
