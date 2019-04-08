package edu.ycp.cs320.independent_study_hub.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
	private Project project;
	private Student lucas;
	
	@Before
	public void setUp() throws Exception {
		lucas = new Student();
		lucas.setEmail("yeet");
		lucas.setName("lucas");
		lucas.setPassword("pass");
		project = new Project("Yeet", lucas, 2019, "Yeet: a Story of Yeet", null, 1);
	}

	@Test
	public void test_constructor() {
		assert project.get_description().equals("Yeet: a Story of Yeet");
		assertNull( project.get_jpeg());
		assert project.get_id() == 1;
		assert project.get_title().equals("Yeet");
		assert project.get_student() == lucas;
	}

}
