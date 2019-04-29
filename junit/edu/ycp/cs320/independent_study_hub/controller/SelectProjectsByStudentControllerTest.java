package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import edu.ycp.cs320.independent_study_hub.model.Project;


public class SelectProjectsByStudentControllerTest {
	private SelectProjectsByStudentController controller;
	List<Project> previousList;

	@Before
	public void setUp() throws Exception {
	controller = new SelectProjectsByStudentController();
	}

	@Test
	public void test_get_coles_projects() {
		previousList = controller.SelectProjectsByStudent("cRohrbaugh");
		assert(previousList.size() == 2);
	}
	
}
