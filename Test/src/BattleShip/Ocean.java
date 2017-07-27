package BattleShip;

import java.util.ArrayList;

import Common.Vector2f;

public class Ocean {
	
	private static int totalID = 0;
	
	private int ID;
	private Player owner;
	private boolean[][] terrainMatrix;
	
	private ArrayList<Boat> boatList = new ArrayList<>(); // each grid belongs to a player, this grid has a number of boats.
	
	public Ocean(){ 
		setTerrainMatrix(new boolean[3][3]);
		totalID++;
		setID(totalID);
	}
	public Ocean(int gridSize){
		setTerrainMatrix(new boolean[gridSize][gridSize]);
		totalID++;
		setID(totalID);
	}
	
	// Accessors
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public boolean[][] getTerrainMatrix() {
		return terrainMatrix;
	}
	public void setTerrainMatrix(boolean[][] terrainMatrix) {
		this.terrainMatrix = terrainMatrix;
	}
	public ArrayList<Boat> getBoatList(){
		return boatList; 
	}
	
	// adds boat to visual grid
	public void popGrid(){
		Boat handle;
		Vector2f drHandle;
		// now we can apply a valid boat to the grid
		for(int x = 0; x < getBoatList().size(); x++){
			handle = boatList.get(x);
			//Vector2f gridOffset = Vector2f.subtract(handle.pos, new Vector2f(1,1));
			drHandle = Vector2f.add(handle.pos, handle.direction);
			// Store references to the grid locations.
			terrainMatrix[handle.pos.x][handle.pos.y] = true;
			
			for(int y = 0; y < handle.length -1; y++){
				terrainMatrix[drHandle.x][drHandle.y] = true;
				drHandle = Vector2f.add(drHandle, handle.direction);
			}
		}
	}
	
	// prints visual of the battle field.
	public void printGrid(){
		System.out.println("Printing terrain grid: " + ID + ", this grid belongs to player: ");
		
		// Header reference
		System.out.print("\t");
		for(int j = 0; j < terrainMatrix.length; j++){
			System.out.print("\t " + (char)(65+j));
		}
		System.out.println();
		
		for(int x = 0; x < terrainMatrix.length ;x++, System.out.println()){
			for(int j = 0; j < terrainMatrix.length; j++){
				if(j == 0) {System.out.print("\t"+x);}
				System.out.print("\t"+(terrainMatrix[j][x] ? "["+1+"]" : " -"));
			}
		}
		
		System.out.println();
	}

}
