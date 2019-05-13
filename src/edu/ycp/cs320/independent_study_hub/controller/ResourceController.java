package edu.ycp.cs320.independent_study_hub.controller;

import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.model.User;
import edu.ycp.cs320.independent_study_hub.model.ResourceBlock;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;
public class ResourceController {
	private IDatabase db = null;
	
	public ResourceController() {
		// this will change to new DerbyDatabase when we get that goin
		DatabaseProvider.setInstance(new DerbyDatabase()); 
		db = DatabaseProvider.getInstance();
	}
	
	public boolean deleteResource (String description) {
		boolean b = db.delete_resource(description);
		if (b) {
			System.out.println("deleted resource block from db");
			return true;
		} 
		
		return false;
	}
	
	public boolean insertResource(String link, String description, String by) {
		boolean b = db.insert_resource(link, description, by);
		if (b) {
			System.out.println("inserted resource into db");
			return true;
		}
		return false;
	}
	
	public ArrayList<ResourceBlock> get_all_resources() {
		ArrayList<ResourceBlock> block_list = db.get_all_resources();
		return block_list;
		
	}
}
