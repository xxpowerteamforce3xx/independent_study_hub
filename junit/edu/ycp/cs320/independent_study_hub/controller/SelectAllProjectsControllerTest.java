package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class SelectAllProjectsControllerTest {
	private SelectAllProjectsController controller;
	private ArrayList<Project> project_list = new ArrayList<Project>();

	@Before
	public void setUp() throws Exception {
		controller = new SelectAllProjectsController();
	}

	@Test
	public void test_sql_query_select_all() {
		project_list = controller.get_all_projects();
		System.out.println("Printing....\n ");
		System.out.println("Projects:");
		for (Project p : project_list) {
			System.out.println(p.get_p_id() + "| " + p.get_s_id() + "| "+ p.get_student().get_name() + ", " + p.get_title() + ", " + p.get_year() + ", " + p.get_description());
		}
		System.out.println("\nPrint Complete");
	}

}
