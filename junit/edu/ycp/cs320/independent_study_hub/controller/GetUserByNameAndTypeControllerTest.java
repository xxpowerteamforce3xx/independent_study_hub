package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.controller.GetUserByNameAndTypeController;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class GetUserByNameAndTypeControllerTest {
	private GetUserByNameAndTypeController controller;
	private Guest guest;
	private Student student;
	private Faculty faculty;
	
	
	@Before
	public void setUp() throws Exception {
		controller = new GetUserByNameAndTypeController();

	}

	@Test
	public void test_get_guest() {
		guest = (Guest) controller.GetUserByNameAndType("guest", 0);
		
	}
	
	@Test
	public void test_get_student() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_get_faculty() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_get_guest_wrong_id() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_get_guest_wrong_name() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_get_student_fac_id() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_get_fac_wrong_name() {
		fail("Not yet implemented");
	}

}
