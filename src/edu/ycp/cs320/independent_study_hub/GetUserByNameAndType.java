package edu.ycp.cs320.independent_study_hub;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.user_models.Faculty;
import edu.ycp.cs320.independent_study_hub.user_models.Guest;
import edu.ycp.cs320.independent_study_hub.user_models.Student;
import edu.ycp.cs320.independent_study_hub.user_models.User;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class GetUserByNameAndType {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);

		System.out.print("enter the name of the account: ");
		String acc_name = keyboard.nextLine();
		System.out.print("what type of account is it? (0 = guest, 1 = student, 2 = faculty): ");
		int acc_type = keyboard.nextInt();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<User> user_list = db.get_user(acc_name, acc_type);
		
		// check if anything was returned and output the list
		if (user_list.isEmpty()) {
			System.out.println("No users found with account type <" + acc_type + "> and account name <" + acc_name + ">");
		}
		else {
			// should only return 1 thing
			
			if (user_list.get(0).get_type() == 0) {		// it is a guest acc
				Guest guest = (Guest) user_list.get(0);
				System.out.println(guest.get_name() + ", " + guest.get_password() + ", " + guest.get_email());
			
			} else if (user_list.get(0).get_type() == 1) {		// student acc
				Student student = (Student) user_list.get(0);
				System.out.println(student.get_name() + ", " + student.get_password() + ", " + student.get_email());
			
			} else if (user_list.get(0).get_type() == 2) {		// facul acc
				Faculty faculty = (Faculty) user_list.get(0);
				System.out.println(faculty.get_name() + ", " + faculty.get_password() + ", " + faculty.get_email());
			}
			
		}
	}
}
