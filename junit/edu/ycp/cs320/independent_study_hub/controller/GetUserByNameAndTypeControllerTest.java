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
	/**
	 * only testing for name and type b/c guest has nothing else
	 */
	public void test_get_guest() {
		guest = (Guest) controller.GetUserByNameAndType("guest", 0);
		assert guest.get_name().equals("guest");
		assert guest.get_type() == 0;
	}
	
	@Test
	public void test_get_student() {
		student = (Student) controller.GetUserByNameAndType("cole", 1);
		assert student.get_name().equals("cole");
		assert student.get_type() == 1;
		assert student.get_password().equals("iamtired");
		assert student.get_email().equals("crohrbaugh@ycp.edu");
	}
	
	@Test
	public void test_get_faculty() {
		faculty = (Faculty) controller.GetUserByNameAndType("Dr.Foy", 2);
		assert faculty.get_name().equals("Dr.Foy");
		assert faculty.get_type() == 2;
		assert faculty.get_password().equals("ilovechemistry");
		assert faculty.get_email().equals("gfoy@ycp.edu");
	}
	
	@Test
	public void test_get_guest_wrong_id() {
		assertNull(controller.GetUserByNameAndType("guest", 1));
	}
	
	@Test
	public void test_get_guest_wrong_name() {
		assertNull(controller.GetUserByNameAndType("yeet doggy", 0));
	}
	
	@Test
	public void test_get_student_fac_id() {
		assertNull(controller.GetUserByNameAndType("ben", 2));
	}
	
	@Test
	public void test_get_fac_wrong_id() {
		assertNull(controller.GetUserByNameAndType("Dr.Steel", 0));
	}
	
	@Test
	public void test_get_fac_wrong_name() {
		assertNull(controller.GetUserByNameAndType("ooh_ooh_ahh_ahh", 2));
	}
	
	@Test
	public void test_get_student_wrong_id_high() {
		assertNull(controller.GetUserByNameAndType("cole", 99));
	}

}
