
package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class InsertProjectControllerTest {
	private InsertProjectController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new InsertProjectController();
	}

	@Test
	public void test_insert_existing_student() {
		assertTrue(controller.insertProject("cole", "how to become blind", 2019, "im now blind and heres how", null, 1));
	}
	
	@Test
	public void test_insert_not_a_student() {
		assertFalse(controller.insertProject("lucas", "how to become blind", 2019, "im now blind and heres how", null, 1));
	}
}
