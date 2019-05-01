package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import edu.ycp.cs320.independent_study_hub.model.*;
import edu.ycp.cs320.independent_study_hub.model.Project;


public class SelectStudentsByFacCodeControllerTest {
	private SelectStudentsByFacCodeController controller;
	ArrayList<Student> s_list;

	@Before
	public void setUp() throws Exception {
	controller = new SelectStudentsByFacCodeController();
	}

	@Test
	public void test_get_coles_projects() {
		s_list = controller.SelectStudentByFacCode("BestProject2019");
		assert(s_list.size() == 3);
	}
	
}
