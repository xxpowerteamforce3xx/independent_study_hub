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
		faculty.setTitle("Dr. Yeet");
		faculty.setInterest("Physical Yeet and organic Yeet");
		faculty.setImg("style/yeet.jpg");
	}

	@Test
	public void test_constructor() {
		assert faculty.get_email().equals("Yeet@gmail.com");
		assert faculty.get_name().equals("Yeet");
		assert faculty.get_password().equals("yeet");
		assert faculty.get_title().equals("Dr. Yeet");
		assert faculty.get_interest().equals("Physical Yeet and organic Yeet");
		assert faculty.get_img().equals("style/yeet.jpg");
	}

}
