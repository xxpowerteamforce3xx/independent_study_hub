package edu.ycp.cs320.independent_study_hub.fake_db;

import java.util.List;
import java.util.Scanner;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class InsertProject_fake_db {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase_fake_db.init(keyboard);
		System.out.print("Enter the name: ");
		String name = keyboard.nextLine();
		System.out.print("Enter the title of the research: ");
		String title = keyboard.nextLine();
		System.out.print("Enter the description: ");
		String description = keyboard.nextLine();
		System.out.print("Enter the year the research was done: ");
		int year = keyboard.nextInt();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		Student student = db.get_student(name);
		if (student != null) {
			List<Project> previousList = db.insertProject(title, student, year, description, null, 1);
			for (Project previous: previousList) {
				System.out.println(previous.get_id() + " , " + previous.get_student().get_name() + "," + previous.get_title() + "," + previous.get_description() + "," + previous.get_year() + "," );
			}
		} else {
			System.out.println("No research found with name <" + name + ">");
		}
		
	}
}
