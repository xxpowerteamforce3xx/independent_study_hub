package edu.ycp.cs320.independent_study_hub.controller;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectOneChemicalControllerTest {
	private SelectOneChemicalController controller;
	private ChemicalInventory chem;

	@Before
	public void setUp() throws Exception {
		controller = new SelectOneChemicalController();
		chem = new ChemicalInventory();
	}

	@Test
	public void test_sql_query_select_one_chem() {
		chem = controller.get_chemical("Methanol");
		System.out.println("Printing...");
		System.out.println("chem -- Methanol");
		System.out.println(chem.getChemicalID() + "| " + chem.getChemical() + ", " + chem.getUseOfChemical() + ", " + chem.getDom());
	}

}
