package Intermediate;

public class MotorBike extends Vehicle {
	
	private String Size;
	
	////
	// Constructor
	////
	
	public MotorBike(String Model, String EngineType, int numOfWheels, float price)
	{
		super(Model, EngineType, numOfWheels, price);
	}
	public MotorBike(String Model, String EngineType, int numOfWheels, float price, String Size)
	{
		super(Model, EngineType, numOfWheels, price);
		this.Size = Size;
	}
	
	////
	// Methods
	////
	
	// settor
	public void setSize(String Size){ this.Size  = Size;}
	
	// Gettor
	public String getSize(){ return Size;}
	public float getPrice(){ return price * 0.65f; }// additional cost
	
	void getDetails(){
		System.out.print("Name: " + getModel() +
						 "\nModelType: " + getEngineType() +
						 "\nNumber of wheels: " + getNumOfWheels() +
						 "\nSize of Vehicle: " + getSize() +
						 "\nPrice: " + getPrice());
	}
}
