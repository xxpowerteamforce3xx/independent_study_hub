package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InsertChemicalIntoInventoryControllerTest {
	private InsertChemicalIntoInventoryController controller; 
	
	@Before
	public void setUp() throws Exception {
		controller = new InsertChemicalIntoInventoryController();
	}

	@Test
	/**
	 * as of right now it will never be false, only throw an exception if wrong input is entered
	 */
	public void test_insert() {
		assertTrue(controller.insertChemical("alchohol", "fun", 2019));
		assertTrue(controller.insertChemical("dogs", "stress relief", 2025));
		assertTrue(controller.insertChemical("music", "sick jams", 1000));
	}
	

}
