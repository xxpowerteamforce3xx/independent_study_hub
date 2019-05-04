package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectAllChemicalsControllerTest {
	private SelectAllChemicalsController controller;
	private ArrayList<ChemicalInventory> chem_list = new ArrayList<ChemicalInventory>();

	@Before
	public void setUp() throws Exception {
		controller = new SelectAllChemicalsController();
	}

	@Test
	public void test_sql_query_select_all() {
		chem_list = controller.get_all_chemicals();
		System.out.println("Printing....\n ");
		System.out.println("Chemicals:");
		for (ChemicalInventory c : chem_list) {
			System.out.println(c.getChemicalID() + "| " + c.getChemical() + ", " + c.getUseOfChemical() + ", " + c.getDom() + ", " + c.getAmount() + "," + c.getMedia());
		}
		System.out.println("\nPrint Complete");
	}

}
