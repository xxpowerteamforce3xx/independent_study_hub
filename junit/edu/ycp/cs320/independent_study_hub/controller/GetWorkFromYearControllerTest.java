package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import edu.ycp.cs320.independent_study_hub.model.Project;


public class GetWorkFromYearControllerTest {
	private GetWorkFromYearController controller;
	List<Project> previousList;

	@Before
	public void setUp() throws Exception {
	controller = new GetWorkFromYearController();
	}

	@Test
	public void test_get_current_year_ben() {
		previousList = controller.GetWorkFromYear(2019);
		String name = previousList.get(1).get_student().get_name();
		assert name.equals("Ben Yanick");
	}
	
	@Test
	public void test_get_current_year_cole() {
		previousList = controller.GetWorkFromYear(2019);
		String name = previousList.get(0).get_student().get_name();
		assert name.equals("Cole Rohrbaugh");
	}
	
	@Test
	public void test_wrong_year() {
		previousList = controller.GetWorkFromYear(2020);
		assertNull(previousList);
	}
}
