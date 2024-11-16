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
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Call the Singleton GameService constructor method to instantiate a
		// GameService object.
		
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// Initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		Game game3 = service.addGame("Game #2");
		System.out.println(game3);
		Game game4 = service.addGame("Game #ABC");
		System.out.println(game4);
		
		// Initialize with some teams
		System.out.println("\n\nAdding teams...");
		Team team1 = game1.addTeam("Avalanche");
		System.out.println(team1);
		Team team2 = game1.addTeam("Car Ramrod");
		System.out.println(team2);
		Team team3 = game2.addTeam("Handsome Mike and the Boys");
		System.out.println(team3);
		Team team4 = game3.addTeam("Clever Team Name");
		System.out.println(team4);
		Team team5 = game4.addTeam("Handsomer Mike and the other Boys");
		System.out.println(team5);
		Team team6 = game3.addTeam("Clever Team Name");
		
		// Initialize with some players
		System.out.println("\n\nAdding players...");
		Player player1 = team1.addPlayer("Conan");
		Player player2 = team1.addPlayer("Bronan");
		Player player3 = team1.addPlayer("Trogdor");
		Player player4 = team2.addPlayer("Rasputin");
		Player player5 = team2.addPlayer("Maxwell");
		Player player6 = team2.addPlayer("Tesla");
		Player player7 = team3.addPlayer("The Man with No Name");
		Player player8 = team3.addPlayer("The Man with a Name");
		Player player9 = team4.addPlayer("Bob");
		Player player10 = team4.addPlayer("Bobby");
		Player player11 = team4.addPlayer("Bobby Bob");
		Player player12 = team5.addPlayer("Mike");
		Player player13 = team5.addPlayer("Boy #1");
		Player player14 = team5.addPlayer("Boy #2");
		Player player15 = team5.addPlayer("Boy #2");
		
		
		// Print the games, teams, players roster to console
		// NOTE: getters were created for this diagnostic purpose only.
		// REMOVE before delivery to client.
		System.out.println("\n\nPrinting game and teams roster: \n");
		for(Game game: service.getGames()) {
			System.out.println("\n" + game);
			for(Team team: game.getTeams()) {
				System.out.println(team);
				for(Player player: team.getPlayers()) {
					System.out.println(player);
				}
			}
			
		}
		
		// Use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
