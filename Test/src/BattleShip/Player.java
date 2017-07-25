package BattleShip;

import java.util.ArrayList;

public class Player {

	private static int totalID = 0;
	
	private int ID;
	private Ocean grid; // each player will have a grid.
	
	// boat
	public Player(){
		totalID++;
		setID(totalID);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}	
	
	public void addBoat(Boat b){
		grid.getBoatList().add(b);
	}
	
	public Ocean getGrid() {
		return grid;
	}

	public void setGrid(Ocean grid) {
		this.grid = grid;
	}

	
	// 2 players
	// each player owns a boat
	
	
	
	
	// each player can declare a vector to strike (each turn)
		// (consideration) if a successful hit occurs, then allow additional shot from same player.
	// each player has a total ship count.
}
