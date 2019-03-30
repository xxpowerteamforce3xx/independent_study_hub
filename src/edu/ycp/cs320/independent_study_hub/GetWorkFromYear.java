package edu.ycp.cs320.independent_study_hub;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.user_models.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.user_models.Faculty;
import edu.ycp.cs320.independent_study_hub.user_models.Guest;
import edu.ycp.cs320.independent_study_hub.user_models.PreviousWork;
import edu.ycp.cs320.independent_study_hub.user_models.Student;
import edu.ycp.cs320.independent_study_hub.user_models.User;
import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;

public class GetWorkFromYear {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);

		System.out.print("Enter the year of the research wanted: ");
		int year = keyboard.nextInt();
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<PreviousWork> previousList = db.getWorkFromYear(year);
		
		// check if anything was returned and output the list
		if (previousList.isEmpty()) {
			System.out.println("No research found with in <" + year + ">");
		}
		else {
			for (PreviousWork previous: previousList) {
				System.out.println(previous.getWorkID() + " , " + previous.getName() + ", " + previous.getTitle() + ", " + previous.getDescription() + ", " + previous.getYear());
			}
		}
	}
}
