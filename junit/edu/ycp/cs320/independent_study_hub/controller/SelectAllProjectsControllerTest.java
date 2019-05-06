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
		assert(project_list.size() == 3);
	}

}
