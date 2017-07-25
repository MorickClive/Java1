package BattleShip;

public class Boat {
	
	// if I do it this way, I'm  going to have to recall a transformation matrix
	// for now let's just implement set positions without concern for the direction.
	int[][] pos;
	float direction;
	int length;
	
	public Boat(){}
	public Boat(int[][] pos, float direction, int length){
		this.pos = pos;
		this.direction = direction;
		this.length = length;
		
	}

}
