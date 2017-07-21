package Intermediate;

public class Truck extends Vehicle {

	boolean hasTowbar;
	
	public Truck(){}
	public Truck(String Model, String EngineType, int numOfWheels, float price, boolean hasTowbar){
		super(Model, EngineType, numOfWheels, price);
		this.hasTowbar = hasTowbar;
	}
	
	public float getPrice(){ return price * 1.25f; }// additional cost
	
	public boolean get_HasTowbar() {
		return hasTowbar;
	}
	public void set_HasTowbar(boolean hasTowbar) {
		this.hasTowbar = hasTowbar;
	}

	void getDetails(){
		System.out.print("Name: " + getModel() +
						 "\nModelType: " + getEngineType() +
						 "\nNumber of wheels: " + getNumOfWheels() +
						 "\nHas a tow bar: " + get_HasTowbar() +
						 "\nPrice: " + getPrice());
	}
	// super can bve a reference to the methods as well.
	
}
