package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectAllFacultyControllerTest {
	private SelectAllFacultyController controller;
	private ArrayList<Faculty> fac_list = new ArrayList<Faculty>();

	@Before
	public void setUp() throws Exception {
		controller = new SelectAllFacultyController();
	}

	@Test
	public void test_sql_query_select_all() {
		fac_list = controller.get_all_faculty();
		System.out.println("Printing...\n ");
		System.out.println("Faculty:");
		for (Faculty f : fac_list) {
			System.out.println(f.getID() + "| " + f.get_name() + ", " + f.get_password() + ", " + f.get_email());
		}
		System.out.println("\nPrint Complete");
	}

}
