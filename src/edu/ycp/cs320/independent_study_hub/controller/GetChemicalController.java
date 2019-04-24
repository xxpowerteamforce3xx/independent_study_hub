package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
public class GetChemicalController {
	private IDatabase db = null;
	
	/**
	 * creates the db instance, for now setting it to only the fake db
	 * since we dont hvae a real one
	 * i spelled have wrong but im leaving it
	 * sue me
	 */
	public GetChemicalController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new FakeDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	/** 										* yeet *
	 * gets the list of chemicals from the year wanted
	 * @param dom --> the year looking for
	 * @return true if found, false for not found
	 */
	public ChemicalInventory GetChemical (String name) {
		ChemicalInventory Chemical = db.get_chemical(name);
		return Chemical;
	}
}
