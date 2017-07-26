package BattleShip;

import java.util.ArrayList;
import java.util.Vector;

import Common.Common;
import Common.Vector2f;

public class Boat extends Common {
	
	// if I do it this way, I'm  going to have to recall a transformation matrix
	// for now let's just implement set positions without concern for the direction.
	Vector2f pos;
	Vector2f direction;
	int length;
	private boolean isAlive;
	public ArrayList<Boolean> mapPositions = new ArrayList<>();
	
	public Boat(){}
	public Boat(Vector2f pos, Vector2f direction, int length){
		this.pos = pos;
		this.direction = direction;
		this.length = length;
		this.setAlive(true);
	}
	
	// methods
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public Vector2f getPos() {
		return pos;
	}
	public void setPos(Vector2f pos) {
		this.pos = pos;
	}
	public Vector2f getDirection() {
		return direction;
	}
	public void setDirection(Vector2f direction) {
		this.direction = direction;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
