package edu.ycp.cs320.independent_study_hub.fake_db;

import java.util.List;
import java.util.Scanner;


import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class GetWorkFromYear_fake_db {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase_fake_db.init(keyboard);

		System.out.print("Enter the year of the research wanted: ");
		int year = keyboard.nextInt();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Project> previousList = db.getWorkFromYear(year);
		
		// check if anything was returned and output the list
		if (previousList.isEmpty()) {
			System.out.println("No research found with in <" + year + ">");
		}
		else {
			for (Project previous: previousList) {
				Student s = previous.get_student();
				System.out.println(previous.get_id() + " , " + s.get_name() + ", " + previous.get_title() + ", " + previous.get_description() + ", " + previous.get_year());
			}
		}
	}
}
