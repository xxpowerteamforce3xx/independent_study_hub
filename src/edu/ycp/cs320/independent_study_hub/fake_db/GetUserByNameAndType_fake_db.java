package edu.ycp.cs320.independent_study_hub.fake_db;

import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class GetUserByNameAndType_fake_db {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// possible fields
		Guest guest;
		Student student;
		Faculty faculty;
		
		// Create the default IDatabase instance
		InitDatabase_fake_db.init(keyboard);

		System.out.print("enter the name of the account: ");
		String acc_name = keyboard.nextLine();
		System.out.print("what type of account is it? (0 = guest, 1 = student, 2 = faculty): ");
		int acc_type = keyboard.nextInt();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		
		if (acc_type == 0) {	
			guest = db.get_guest(acc_name);
			System.out.println(guest.get_name() + ", " + guest.get_password());

		} else if (acc_type == 1) {
			student = db.get_student(acc_name);
			System.out.println(student.get_name() + ", " + student.get_password() + ", " + student.get_email());

		} else if (acc_type == 2) {
			faculty = db.get_faculty(acc_name);
			System.out.println(faculty.get_name() + ", " + faculty.get_password() + ", " + faculty.get_email());

		} else {
			System.out.println("No user was found with the name " + acc_name + " and type "+ acc_type);
		}

		
	}
}
