package edu.ycp.cs320.independent_study_hub.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FacultyTest {
	private Faculty faculty = new Faculty();
	
	@Before
	public void setUp() throws Exception {
		faculty.setName("Yeet");
		faculty.setEmail("Yeet@gmail.com");
		faculty.setPassword("yeet");
	}

	@Test
	public void test_constructor() {
		assert faculty.get_email().equals("Yeet@gmail.com");
		assert faculty.get_name().equals("Yeet");
		assert faculty.get_password().equals("yeet");
	}

}
