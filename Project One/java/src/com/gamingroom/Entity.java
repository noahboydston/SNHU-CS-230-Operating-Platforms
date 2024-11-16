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

public class Entity {

	private long id;
	private String name;
	
	private Entity() {
	}
	
	/* Overloaded constructor for common attributes id, name 
	 * 
	 * @param id unique ID number, name unique name
	 */
	public Entity(long id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	/* Returns the Entity ID 
	 * 
	 * @return the Entity id
	 */
	public long getId() {
		return id;
	}
	
	/* Returns the Entity name 
	 * 
	 * @return the Entity name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}

}
