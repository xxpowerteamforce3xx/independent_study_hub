package edu.ycp.cs320.independent_study_hub.controller;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectOneFacultyControllerTest {
	private SelectOneFacultyController controller;
	private Faculty f;
	private Faculty f1;
	private Faculty f2;

	@Before
	public void setUp() throws Exception {
		controller = new SelectOneFacultyController();
		f = new Faculty();
		f1 = new Faculty();
		f2 = new Faculty();
	}

	@Test
	public void test_sql_query_select_all() {
		f = controller.get_faculty("Dr.Steel");
		System.out.println("Printing....\n ");
		System.out.println("Faculty:");
		System.out.println(f.getID() + "| " + f.get_name() + ", " + f.get_password() + ", " + f.get_email());
		System.out.println("\nPrint Complete");
		
		f1 = controller.get_faculty("Dr.Foy");
		System.out.println("Printing....\n ");
		System.out.println("Student:");
		System.out.println(f1.getID() + "| " + f1.get_name() + ", " + f1.get_password() + ", " + f1.get_email());
		System.out.println("\nPrint Complete");
		
		f2 = controller.get_faculty("Dr.Fautch");
		System.out.println("Printing....\n ");
		System.out.println("Faculty:");
		System.out.println(f2.getID() + "| " + f2.get_name() + ", " + f2.get_password() + ", " + f2.get_email());
		System.out.println("\nPrint Complete");
	}

}
