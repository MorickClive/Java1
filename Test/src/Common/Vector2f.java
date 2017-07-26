package Common;

public class Vector2f {
	// I don't need a full library to create a basic V2
	public int	x,	y; // access should be public, it's an extended type.
	
	// default constructor
	public Vector2f(){
		x = y = 0;
	}
	public Vector2f(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// two simple operations - I don't want a matrix based system.
	public static Vector2f add(Vector2f x, Vector2f y){
		return new Vector2f(x.x + y.x, x.y + y.y);
	}
	public static Vector2f subtract(Vector2f x, Vector2f y){
		return new Vector2f(x.x - y.x, x.y - y.y);
	}
	
	public static Vector2f UP(){
		return new Vector2f(0,1);
	}
	// would have inversed the operation but Java "forbids" it
	public static Vector2f DOWN(){
		return new Vector2f(0,-1);
	}
	public static Vector2f RIGHT(){
		return new Vector2f(1,0);
	}
	// would have inversed the operation but Java "forbids" it
	public static Vector2f LEFT(){
		return new Vector2f(-1,0);
	}
	
	// Multiply - very much greater complexity.
	public static void ABSOLUTE(Vector2f v){
		v.x = Math.abs(v.x);
		v.y = Math.abs(v.y);
	}
	
	public static String PRINT(Vector2f v){
		return "{x: "+ v.x +", y:"+ v.y + "}";
	}

}
