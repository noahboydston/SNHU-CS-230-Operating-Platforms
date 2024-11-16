/*
 * Noah Boydston
 * SNHU CS-230-17582-M01 Operating Platforms
 * Project One - The Gaming Room
 * 
 * A proof of concept program written in Java to demonstrate principles of OOP.
 * The ProgramDriver creates a Singleton GameService, is loaded with test data
 * for Game, Team, and Player objects, and id and name attributes are printed
 * to the console.  The program includes a class to test Singleton status of
 * the GameService object.
 */

package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// Call the Singleton GameService constructor method to instantiate a
		// GameService object.
		// If a GameService instance already exists, output message to console
		// indicating instance is already created.
		
		GameService service = GameService.getInstance();
		
		// A simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
