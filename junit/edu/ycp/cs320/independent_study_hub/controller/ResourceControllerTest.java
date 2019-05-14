package edu.ycp.cs320.independent_study_hub.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.ResourceBlock;
import edu.ycp.cs320.independent_study_hub.model.Student;

public class ResourceControllerTest {
	private ResourceController controller;
	private ArrayList<ResourceBlock> resource_list = new ArrayList<ResourceBlock>();

	@Before
	public void setUp() throws Exception {
		controller = new ResourceController();
	}

	@Test
	public void test_sql_query_select_all() {
		resource_list = controller.get_all_resources();
		System.out.println("Printing....\n ");
		System.out.println("Resources:");
		for (ResourceBlock r : resource_list) {
			System.out.println(r.get_description() + "| " + r.get_by() + ", " + r.get_link());
		}
		System.out.println("\nPrint Complete");
	}

}
