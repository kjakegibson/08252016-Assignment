package com.assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void connToDB() {
		
		try {
			System.out.println("Trying to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
			
		} catch (SQLException e) {
			System.out.println("Failed to conenct to the database.");
			e.printStackTrace();
		}
	}
	
	public static void readFromDB(){
		
		connToDB();
		
		ArrayList<Animal> ourAnimals = new ArrayList<>();
		
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM school.animals;");
			
			while(RES_SET.next()){
			
			Animal animalInDB = new Animal();
			
			animalInDB.setAnimalid(RES_SET.getString("animalid"));
			animalInDB.setSpecies(RES_SET.getString("species"));
			animalInDB.setName(RES_SET.getString("name"));
			animalInDB.setEnclosure(RES_SET.getString("enclosure"));
			animalInDB.setWeight(RES_SET.getDouble("weight"));
			
			ourAnimals.add(animalInDB);
			
			}
		
	for (Animal animal : ourAnimals) {	
		System.out.println(animal.toString());
		
	}
		
		
	} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public static void writeToDB() {
		
		Animal animalToAdd = new Animal();
		
		animalToAdd = aboutTheAnimal();
		
		connToDB();
		
		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);
			
			PREP_STMT.setString(1, animalToAdd.getSpecies());
			PREP_STMT.setString(2, animalToAdd.getName());
			PREP_STMT.setString(3, animalToAdd.getEnclosure());
			PREP_STMT.setDouble(4, animalToAdd.getWeight());
			
			PREP_STMT.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static String insertToDB = "INSERT INTO `school`.`animals`"
			+ "(species, name, enclosure, weight)"
			+ " VALUES "
			+ "(?, ?, ?, ?)";
	
	public static Animal aboutTheAnimal(){
		
		Animal animalToAdd = new Animal();
		
		System.out.println("What species is the animal?");
		animalToAdd.setSpecies(sc.nextLine());
		
		System.out.println("What is the animal's name?");
		animalToAdd.setName(sc.nextLine());
		
		System.out.println("What kind of enclosure is the animal in?");
		animalToAdd.setEnclosure(sc.nextLine());
		
		System.out.println("What is the animal's weight?");
		animalToAdd.setWeight(Double.parseDouble(sc.nextLine()));
		
		return animalToAdd;
		
		
		
		
	}
	
	public static void deleteFromDB() {

        connToDB();

        try {
            System.out.println("Please enter the Animal ID  number you would like to delete.");
            String deleteAnimal = sc.nextLine();

            PREP_STMT = CONN.prepareStatement(deleteFromDB);
            PREP_STMT.setString(1, deleteAnimal);

            PREP_STMT.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static String deleteFromDB = "DELETE FROM `school`.`animals` WHERE animalid = ?";
	
	
	public static void updateTheDatabase() {
	       
	       System.out.println("What is the ID# of the animal you'd like to update?");
	       
	       int idNumber = Integer.parseInt(sc.nextLine());
	       
	       Animal animalToUpdate = new Animal();
	       
	       animalToUpdate = aboutTheAnimal();
	       
	       connToDB();
	               
	       try {
	           PREP_STMT = CONN.prepareStatement("UPDATE `school`.`animals`SET"
	                   + " `species` = ?, `name` = ?, `enclosure` = ?, `weight` = ?,"
	                   + " WHERE `animal_id` = ?;");
	           PREP_STMT.setString(1, animalToUpdate.getSpecies());
	           PREP_STMT.setString(2, animalToUpdate.getName());
	           PREP_STMT.setString(3, animalToUpdate.getEnclosure());
	           PREP_STMT.setDouble(4, animalToUpdate.getWeight());
	           PREP_STMT.setInt(6, idNumber);
	           
	           PREP_STMT.executeUpdate();
	           
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }            
	   }
	private static String updateTheDatabase
	
}
	
	

