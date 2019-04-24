
package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class InsertChemicalControllerTest {
	private InsertChemicalController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new InsertChemicalController();
	}

	@Test
	public void test_insert_new_student() {
		assertTrue(controller.insertChemical("meth", "creative thinking", 21));
		assertTrue(controller.insertChemical("coffee", "recreation", 0));
	}
	
}
