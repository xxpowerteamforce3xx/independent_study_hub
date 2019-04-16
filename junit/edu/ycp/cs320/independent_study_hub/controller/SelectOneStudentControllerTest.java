package edu.ycp.cs320.independent_study_hub.controller;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectOneStudentControllerTest {
	private SelectOneStudentController controller;
	private Student s;
	private Student s1;

	@Before
	public void setUp() throws Exception {
		controller = new SelectOneStudentController();
		s = new Student();
		s1 = new Student();
	}

	@Test
	public void test_sql_query_select_all() {
		s = controller.get_student("Cole Rohrbaugh");
		System.out.println("Printing....\n ");
		System.out.println("Student:");
		System.out.println(s.getID() + "| " + s.get_name() + ", " + s.get_password() + ", " + s.get_email());
		System.out.println("\nPrint Complete");
		
		s1 = controller.get_student("Ben Yanick");
		System.out.println("Printing....\n ");
		System.out.println("Student:");
		System.out.println(s1.getID() + "| " + s1.get_name() + ", " + s1.get_password() + ", " + s1.get_email());
		System.out.println("\nPrint Complete");
	}

}
