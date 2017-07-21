package Intermediate;

// This is where the lecture talked about scanners for user input.
public class Vehicle {
	static private int ID_Total = 0;
	private int ID = 0; // should be auto-assigned.
	
	private String Model = "MISSING";
	private String EngineType = "MISSING";
	private int numOfWheels = 1;
	protected float price;

	public Vehicle(){ ID_Total += 1; ID = ID_Total;}
	public Vehicle(String Model, String EngineType, int numOfWheels, float price){
		ID_Total += 1;
		this.ID = ID_Total;
		this.Model = Model;
		this.EngineType = EngineType;
		this.numOfWheels = numOfWheels;
		this.price = price;
	}
	
	////
	// Methods
	////
	
	// settor
	public void setModel(String Model){ this.Model  = Model;}
	public void setEngineType(String EngineType){ this.EngineType = EngineType;}
	public void setNumOfWheels(int numOfWheels){ this.numOfWheels  = numOfWheels;}
	
	// gettor
	public String getModel(){ return Model;}
	public String getEngineType(){ return EngineType;}
	public int getNumOfWheels(){ return numOfWheels;}
	public float getPrice(){ return price; }// full price
	
	// Functions
	public int getID(){ return ID;}
	public String getIDformatted(){return String.format("%05d", ID);}
	
	void getDetails(){
		System.out.print("Name: " + getModel() +
						 "\nModelType: " + getEngineType() +
						 "\nNumber of wheels: " + getNumOfWheels() +
						 "\nPrice: " + getPrice() +
						 "\n");
	}
}
