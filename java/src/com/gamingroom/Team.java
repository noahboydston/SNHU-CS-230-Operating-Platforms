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
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	
	/* A private list of players on the team 
	 * 
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		
		super(id, name);
	}
	
	/* A method to add a player to a team. 
	 * 
	 * @param name the name of the player
	 * @return the player object
	 */
	public Player addPlayer(String name) {
		
		// A local Player instance
		Player player = null;
		
		// An Iterator pattern is used to cycle through the list
		// of players.  If a player with the same name is found,
		// a message is output to the console.  Otherwise, the player
		// is added.
		Iterator<Player> playersIterator = players.iterator();
		
		while(playersIterator.hasNext()) {
			
			Player currentPlayer = playersIterator.next();
			
			if(currentPlayer.getName().equalsIgnoreCase(name)) {
				System.out.println("Player " + currentPlayer.getName() + " already exists.");
				return currentPlayer;
			}
		}
		
		if(player == null) {
			player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
		}
		
		return player;
	}
	
	// Method added to display Team roster information for demonstration only.
	// Remove this method before delivery!
	public List<Player> getPlayers(){
		return this.players;
	}

	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
