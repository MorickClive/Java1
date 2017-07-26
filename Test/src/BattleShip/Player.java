package BattleShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Common.Vector2f;

public class Player {

	private static int totalID = 0;
	
	private int ID;
	private Ocean grid; // each player will have a grid.
	private int totalShips = 0;
	
	// boat
	public Player(){
		totalID++;
		setID(totalID);
		this.grid = new Ocean(3);
	}
	public Player(int gridSize){
		totalID++;
		setID(totalID);
		this.grid = new Ocean(gridSize);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}	
	
	public void addBoat(Boat b){
		boolean proceed = false;
		proceed = legalPlaceCheck(grid, b) ? !proceed : proceed;
		
		if(proceed){
			grid.getBoatList().add(b);
			updateBoat(b);
			grid.popGrid();
		}
		else{
			System.out.println("Boat placement failed.");			
		}
	}
	
	private void updateBoat(Boat b){
		// get grid and pull the boolean values onto a list stored on boat
		boolean[][] grid = getGrid().getTerrainMatrix();
		Vector2f handle = Vector2f.add(b.direction, b.pos);
		
		b.mapPositions.add(grid[b.pos.x][b.pos.y]);
		System.out.println(Vector2f.PRINT(b.pos));
		
		for(int x = 1; x < b.length; x++){
			System.out.println(Vector2f.PRINT(handle));
			b.mapPositions.add(grid[handle.x][handle.y]);
			handle = Vector2f.add(handle, b.direction);
		}
		
		// remove any entries that do not match the value "true"
		
		for(int x = 0; x < b.length; x++){
			// should the value we have stored be false - we know we've been hit.
			if(b.mapPositions.get(x) == false) { b.mapPositions.remove(x);	} 
		}
		
		// if we have no valid positions, we are dead
		b.setAlive( b.mapPositions.size() <= 0 ? false : true);
		if(!b.isAlive()){System.out.println("Ship is dead.");}
		
	}
	
	private boolean legalPlaceCheck(Ocean o, Boat b){
		
		boolean[][] grid = o.getTerrainMatrix();		
		Boat handle = b;
		Vector2f drHandle;
		String collisionMsg = "Cannot place boat, would collide with another boat";
		
		// now we can apply a valid boat to the grid
		drHandle = Vector2f.add(handle.pos, handle.direction);
			try{
				// if the origin collides - fail
				if (grid[handle.pos.x][handle.pos.y] == true) {
					System.out.println(collisionMsg);
					return false;
					}
				// check our length
				for(int y = 0; y < handle.length-1; y++){
					// if length collides - fail
					if(grid[drHandle.x][drHandle.y] == true){
						System.out.println(collisionMsg);
						return false;
						}
					drHandle = Vector2f.add(drHandle, handle.direction);
				}
			}catch(ArrayIndexOutOfBoundsException e){
				// You're our of bounds
				System.out.println("Boat exceeds grid limits!!!");
				System.out.println("Error:\n" + e);
				return false;
			}
			finally{}
		
			System.out.println("Boat has been placed!!");
		// everything checks out, allow placement
		return true;
	}
	
	public Ocean getGrid() {
		return grid;
	}

	public void setGrid(Ocean grid) {
		this.grid = grid;
	}
	
	public boolean shootTarget(Player targ, Vector2f pos){
		
		boolean [][] grid = targ.getGrid().getTerrainMatrix();
		
		if(grid[pos.x][pos.y] == true) {
			grid[pos.x][pos.y] = false;
			System.out.println("Player " + getID() + " hit Player " + targ.getID() + "'s ships.");
			
			return true;
			
		}
		else{
			System.out.println("Player " +getID() + " missed any ships that Player " + targ.getID()+" owned.");
			return false;
		}
		
	}
	
	public boolean updateBoats(){
		totalShips = 0;		
		
		for(int x = 0; x < getGrid().getBoatList().size(); x++){
			updateBoat(getGrid().getBoatList().get(x));
			totalShips += getGrid().getBoatList().get(x).isAlive() ? 1 : 0;
		}
		
		if(totalShips <= 0){
			System.out.println("A player died.");
			return false;
		}
		
		return true;
	}
	
	

	
	// 2 players
	// each player owns a boat
	
	
	
	
	// each player can declare a vector to strike (each turn)
		// (consideration) if a successful hit occurs, then allow additional shot from same player.
	// each player has a total ship count.
}
