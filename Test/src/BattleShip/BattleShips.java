package BattleShip;

import java.util.ArrayList;
import java.util.HashMap;

public class BattleShips {
	
	// one terrain // for now
	HashMap<Integer, Player> playerList = new HashMap<>(); // ID to player.
	
	public BattleShips(){	
		start();
		
	}
	public BattleShips(int numPlayers){
		start();
	}
	
	public void start(){
		// This is the game loop
			//while loop (condition)		
		Boat b = new Boat(new int[][] {{1},{1}},0,1);
		
		playerList.put(1, new Player());
		playerList.get(1).addBoat(b);
		
		playerList.get(1).getGrid().printGrid();
		
	}
	

}
