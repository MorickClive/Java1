package BattleShip;

import java.util.ArrayList;

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
	public Ocean(int gridSize, Player owner){
		setTerrainMatrix(new boolean[gridSize][gridSize]);
		totalID++;
		setID(totalID);
		this.owner = owner;
		
		boatList.add(new Boat(new int[][] {{1},{1}},0,1));
		setTerrainMatrix(new boolean[][] {{false,true},{false,true}});
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
	
	public void printGrid(){
		
		System.out.println("Printing terrain grid: " + ID + ", this grid belongs to player: " + owner.getID());				
		for(int x = 0; x < terrainMatrix.length ;x++, System.out.println()){
			for(int j = 0; j < terrainMatrix.length; j++){
				System.out.print("\t"+(terrainMatrix[j][x] ? 1 : 0));
			}
		}
		
		System.out.println();
	}

}
