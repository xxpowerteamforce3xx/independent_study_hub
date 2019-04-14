package edu.ycp.cs320.independent_study_hub.fake_db;

import java.util.Scanner;

import edu.ycp.cs320.independent_study_hub.persist.DatabaseProvider;
import edu.ycp.cs320.independent_study_hub.persist.FakeDatabase;
import edu.ycp.cs320.independent_study_hub.persist.DerbyDatabase;

public class InitDatabase_fake_db {
	public static void init(Scanner keyboard) {
		System.out.println("if u press 1 itll throw an exception, no real db yet") ;
		System.out.print("Which database (0=fake, 1=derby): ");
		int which = Integer.parseInt(keyboard.nextLine());
		if (which == 0) {
			DatabaseProvider.setInstance(new FakeDatabase());
		} else if (which == 1) {
			DatabaseProvider.setInstance(new DerbyDatabase());
		} else {
			throw new IllegalArgumentException("Invalid choice: " + which);
		}
	}
}
