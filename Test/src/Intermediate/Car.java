package Intermediate;

public class Car extends Vehicle {
	private int NoOfWindows = 6;
	private String gearBox = null;
	
	public Car(String Model, String EngineType, int numOfWheels, float price)
	{
		super(Model, EngineType, numOfWheels, price);
	}
	public Car(String Model, String EngineType, int numOfWheels, float price, int NoOfWindows, String gearbox)
	{
		super(Model, EngineType, numOfWheels, price);
		this.NoOfWindows = NoOfWindows;
		this.gearBox = gearbox;
	}
	
	////
	// Methods
	////
	
	// settor
	public void setNoOfWindows(int NoOfWindows){ this.NoOfWindows  = NoOfWindows;}
	public void setGearBox(String gearBox){ this.gearBox = gearBox;}
	
	// gettor
	public int getNoOfWindows(){ return NoOfWindows;}
	public String getGearBox(){ return gearBox;}
	public float getPrice(){ return price * 1.75f; }// additional cost
	
	void getDetails(){
		System.out.print("Name: " + getModel() +
						 "\nModelType: " + getEngineType() +
						 "\nNumber of wheels: " + getNumOfWheels() +
						 "\nNumber of windows:" + getNoOfWindows() +
						 "\nGearbox type: "+ getGearBox() +
						 "\nPrice: " + getPrice());
	}
}
