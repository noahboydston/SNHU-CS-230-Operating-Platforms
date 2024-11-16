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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A static list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game, team and player identifier
	 */
	private static long nextGameId = 1;
	
	private static long nextPlayerId = 1;
	
	private static long nextTeamId = 1;

	// A static GameService object is created to implement Singleton.
	
	private static GameService service;
	
	// A private default constructor prevents the creation of 
	// multiple GameService instances.
	
	private GameService() {
	}
	
	// Singleton method to instantiate a GameService object if
	// one has not been instantiated.  Outputs message to console
	// if GameService instance already exists.
	// @return the GameService
	
	public static GameService getInstance() {
		if(service == null) {
			service = new GameService();
			System.out.println("Game service created.");
		} else {
			System.out.println("Game service has already been created.");
		}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// A local game instance
		Game game = null;
		
		// Iterator pattern is used to check through list of games for
		// Game object of same name (parameter).
		// If a Game object is found in the games list, return the
		// existing instance.
		
		Iterator<Game> gamesIterator = games.iterator();
		
		while(gamesIterator.hasNext()) {
			
			Game currentGame = gamesIterator.next();
			
			if(currentGame.getName().equalsIgnoreCase(name)) {
				System.out.println("Game " + currentGame.getName() + " already exists.");
				return currentGame;
			}
		}

		// If not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// Return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		// Iterator pattern is used to check through list of games for
		// Game object of same id (parameter).
		// If a Game object is found in the games list, return the
		// existing instance.
		
		Iterator<Game> gamesIterator = games.iterator();
		
		while(gamesIterator.hasNext()) {
			Game currentGame = gamesIterator.next();
			if(currentGame.getId() == id) {
				System.out.println("Game ID: " + currentGame.getId() + " found.");
				return currentGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// A local Game instance
		Game game = null;
		
		// Iterator pattern is used to check through list of games for
		// Game object of same name (parameter).
		// If a Game object is found in the games list, return the
		// existing instance.
		
		Iterator<Game> gamesIterator = games.iterator();
		
		while(gamesIterator.hasNext()) {
			Game currentGame = gamesIterator.next();
			if(currentGame.getName().equalsIgnoreCase(name)) {
				System.out.println("Game " + currentGame.getName() + " found.");
				return currentGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/* Returns the incremented Player ID 
	 * 
	 * @return the incremented nextPlayerId
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/* Returns the incremented Team ID 
	 * 
	 * @return the incremented nextTeamId
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
	// Method added to display Team roster information for demonstration only.
	// Remove this method before delivery!
	public List<Game> getGames(){
		return this.games;
	}
}
