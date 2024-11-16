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
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	/*
	 * A private list of this game's included teams
	 */	
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		
		super(id, name);
	}
	
	/* A method to add a Team to the Game 
	 * 
	 * @param name the Team name
	 * @return the Team object
	 */
	public Team addTeam(String name) {
		
		// a local Team instance
		Team team = null;
		
		// An Iterator pattern is used to cycle through the list of
		// teams.  If a team with the same name is found, a message
		// is output to the console.  Otherwise, the team is added.
		Iterator<Team> teamsIterator = teams.iterator();
		
		while(teamsIterator.hasNext()) {
			
			Team currentTeam = teamsIterator.next();
			
			if(currentTeam.getName().equalsIgnoreCase(name)) {
				System.out.println("Team " + currentTeam.getName() + " already exists.");
				return currentTeam;
			}
		}
		
		if(team == null) {
			team = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(team);
		}
		
		return team;
	}
	
	// Method added to display Team roster information for demonstration only.
	// Remove this method before delivery!
	public List<Team> getTeams(){
		return this.teams;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + this.getId() + ", name=" + this.getName() + "]";
	}

}
