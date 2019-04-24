
package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class InsertStudentControllerTest {
	private InsertStudentController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new InsertStudentController();
	}

	@Test
	public void test_insert_new_student() {
		assertTrue(controller.insertStudent("Lucas", "lucasisawesome", "lgartrell@ycp.edu"));
		assertTrue(controller.insertStudent("Hake", "elon", "elonsBiggestFan@aol.com"));
	}
	
}
