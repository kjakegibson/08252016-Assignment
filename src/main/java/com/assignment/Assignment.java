package com.assignment;

import java.util.Scanner;

public class Assignment {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String userMenuInput = null;
		boolean menuCorrect = false;
		
		
		System.out.println("Welcome to the zoo information program!");
		
		do {
			System.out.println("Press 1 to read the database" + "\nPress 2 to add to the database."
					+ "\nPress 3 to delete from the database." + "\nPress 4 to update the database.");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
				DAO.writeToDB();
				break;
			case "3":
				DAO.deleteFromDB();
				break;
			case "4":
				DAO.updateTheDatabase();
				break;
			default:
				System.out.println("You've entered an invalid option :D");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
		sc.close();
	}
}
