package pattern_Decorator;

public class topping extends Pizza{

	Pizza ourPizza;
	
	public topping(){}
	public topping(Pizza ourPizza){ 
			this.ourPizza = ourPizza;
		}
	
}
