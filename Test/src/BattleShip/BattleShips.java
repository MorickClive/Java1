package BattleShip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Common.Common;
import Common.Vector2f;

public class BattleShips extends Common {
	
	// one terrain // for now
	HashMap<Integer, Player> playerList = new HashMap<>(); // ID to player.
	
	public BattleShips(){	
		start();
		
	}
	public BattleShips(int numPlayers){
		start();
	}
	
	public void start(){		
		// I like the idea of "local" globals
		boolean gameActive = true;
		int gridSize = 12;
		Player P1, P2;
		
		// This sets up the players, the rules and the basis of each game	
		Init(gridSize);
		// These are samples of players that have been initialised
		P1 = playerList.get(1);
		P2 = playerList.get(2);
		
		// This is the game loop
			//while loop (condition)		
		while(gameActive){
			
			playerTurn(P1, P2);
			playerTurn(P2, P1);
			//P1.shootTarget(P2, new Vector2f(0,3));
			//P2.shootTarget(P1, new Vector2f(0,3));
			
			
			//gameActive = P1.updateBoats();
			//gameActive = P2.updateBoats();
			// my exit condition
			// We update both Players, should either have no boats left, we will terminate the loop.
			gameActive = P1.updateBoats() && P2.updateBoats() ? true : false;
			//gameActive = !gameActive;
		}
		
		System.out.println();		
	}
	
	public void Init(int gridSize){
		Player P1, P2; // Local copies for reference to different players
		
		//P1 details
			playerList.put(1, new Player(gridSize));
			P1 = playerList.get(1);
			//P1.addBoat(b);
			P1.addBoat(new Boat(new Vector2f(0,3), Vector2f.DOWN(), 2));
			P1.addBoat(new Boat(new Vector2f(2,2), Vector2f.RIGHT(), 2));
			P1.addBoat(new Boat(new Vector2f(8,8), Vector2f.UP(), 3));
			
			P1.addBoat(new Boat(new Vector2f(5,3), Vector2f.UP(), 3));
			P1.addBoat(new Boat(new Vector2f(6,6), Vector2f.RIGHT(), 3));
			P1.addBoat(new Boat(new Vector2f(1,8), Vector2f.DOWN(), 4));
			
			P1.addBoat(new Boat(new Vector2f(11,7), Vector2f.DOWN(), 5));
			
			P1.getGrid().printGrid();
		
		//P2 details
			playerList.put(2, new Player(gridSize));
			P2 = playerList.get(2);
			//P2.addBoat(new Boat(new Vector2f(0,2), Vector2f.UP(), 3));
			P2.addBoat(new Boat(new Vector2f(0,0), Vector2f.RIGHT(), 2));
			P2.addBoat(new Boat(new Vector2f(2,2), Vector2f.LEFT(), 2));
			P2.addBoat(new Boat(new Vector2f(1,5), Vector2f.RIGHT(), 3));
			
			P2.addBoat(new Boat(new Vector2f(5,3), Vector2f.LEFT(), 3));
			P2.addBoat(new Boat(new Vector2f(6,6), Vector2f.UP(), 3));
			P2.addBoat(new Boat(new Vector2f(7,5), Vector2f.RIGHT(), 4));
			
			P2.addBoat(new Boat(new Vector2f(11,7), Vector2f.DOWN(), 5));
			
			
			P2.getGrid().printGrid();
			
			
			
//			2 patrol boats (1 x 2),
//			 2 battleships (1 x 3),
//			 1 submarine (1 x 3),
//			 1 destroyer (1 x 4)
//			 and 1 carrier (1 x 5).

	}
	
	public void playerTurn(Player P, Player Enemy){
		Scanner sc = new Scanner(System.in);
		Vector2f coord = new Vector2f();
		boolean activeTurn = true;
		int turnTracker = 1;
		int gridLength = P.getGrid().getTerrainMatrix().length;
		
		while(activeTurn){
			//It's your turn!!
			System.out.println("Player " + P.getID() + " Turn "+turnTracker);
			System.out.println("------------------------");
			System.out.println("Enter coordinates to fire in grid " + gridLength + "x" + gridLength + ".\n");
			
			
			// enter a value with success
			// this ensures a vector/coordinate is entered and accepted without crashing the system.
			do{
				try{
					System.out.print("Coordinate X: ");
					coord.x = Integer.parseInt(sc.nextLine());
				}catch(Exception e){
					// if error, throw max value +1
					coord.x += gridLength+1;
					}
				try{
					System.out.print("Coordinate Y: ");
					coord.y = Integer.parseInt(sc.nextLine());
				}catch(Exception e){
					// if error, throw max value +1
					coord.y += gridLength+1;
					}
				
				// Abs values
				Vector2f.ABSOLUTE(coord);
				
				// should you fail...
				if((coord.x < gridLength && coord.y < gridLength) ? false : true){
					System.out.println(	"You cannot have a value that exceeds the grid value!!"+ "\n" +
										"you entered: " + "{"+coord.x+", "+ coord.y + "}.\n");
					System.out.println("Enter coordinates to fire in grid " + gridLength + "x" + gridLength + ".");
					
				}
			}while((coord.x > gridLength || coord.y > gridLength) ? true : false); // we can only have values above 0 and less than grid length
			
			
			// We have our successful Coordinate/Vector2f. let's fire at this location.
			
			System.out.println("Player " + P.getID() + " fired at: {"+coord.x+", "+ coord.y + "}.");
			
			System.out.print("\tBoom"); printDelayed("...\n", 500);
			
			// if we successfully hit, we're still allowed to fire again - let the while loop continue
			activeTurn = P.shootTarget(Enemy, new Vector2f(coord.x,	coord.y));
			if(activeTurn){	
					Sleep(500*2);
					print("SUCCESS!\n Player " + P.getID() + " gets another turn!!\n");
					Sleep(500*4);
				}
			System.out.println("------------------------\n\n");
			consoleSpace(20); // space it out by
			turnTracker++;
		}
	}
	
	public void consoleSpace(int space){
		int count = space;
		for(int x = 0; x < count; x++){
			System.out.print("\n");
		}
	}
}
