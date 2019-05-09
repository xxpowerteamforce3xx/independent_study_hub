
package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DeleteChemicalControllerTest {
	private DeleteChemicalController controller;
	private InsertChemicalController controller2;
	@Before
	public void setUp() throws Exception {
		controller = new DeleteChemicalController();
		controller2 = new InsertChemicalController();
	}

	@Test
	public void test_delete_controller() {
		assertTrue(controller2.insertChemical("meth", "creative thinking", "01/12/19", 50, "Liquid(mL)"));
		assertTrue(controller2.insertChemical("coffee", "recreation", "02/15/19", 50, "Solid(g)"));
		assertTrue(controller.deleteChemical("meth"));
		assertTrue(controller.deleteChemical("coffee"));
	}
	
}
