package edu.ycp.cs320.independent_study_hub.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	private Student student = new Student();
	@Before
	public void setUp() throws Exception {
		student.setName("Yeet");
		student.setEmail("Yeet@gmail.com");
		student.setPassword("yeet");
	}

	@Test
	public void test_constructor() {
		assert student.get_email().equals("Yeet@gmail.com");
		assert student.get_name().equals("Yeet");
		assert student.get_password().equals("yeet");
	}

}
