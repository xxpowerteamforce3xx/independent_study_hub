package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectAllStudentsControllerTest {
	private SelectAllStudentsController controller;
	private ArrayList<Student> student_list = new ArrayList<Student>();

	@Before
	public void setUp() throws Exception {
		controller = new SelectAllStudentsController();
	}

	@Test
	public void test_sql_query_select_all() {
		student_list = controller.get_all_students();
		System.out.println("Printing....\n ");
		System.out.println("Students:");
		for (Student s : student_list) {
			System.out.println(s.getID() + "| " + s.get_name() + ", " + s.get_password() + ", " + s.get_email());
		}
		System.out.println("\nPrint Complete");
	}

}
