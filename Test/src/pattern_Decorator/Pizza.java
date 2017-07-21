package pattern_Decorator;

public class Pizza {
	
	float price = 5; // each pizza is based around £5
	topping toppings = new topping();
	
	public Pizza(){}
	public Pizza(float price){
		//this.price = price;
	}
	
	////
	// Methods
	///
	
	// Gettors and Settors	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
