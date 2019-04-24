
package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class InsertFacultyControllerTest {
	private InsertFacultyController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new InsertFacultyController();
	}

	@Test
	public void test_insert_new_student() {
		assertTrue(controller.insertFaculty("Prof. Lucas", "lucasisawesome", "lgartrell@ycp.edu"));
		assertTrue(controller.insertFaculty("Prof. Dr. Mr. Cole", "science", "elonsBiggestFan@aol.com"));
		assertTrue(controller.insertFaculty("Mrs. Ben", "quilts", "cyberdragon@gmail.com"));
	}
	
}
