package Intermediate;

import java.util.*;

public class Garage {

	private String location = "MISSING";
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Garage(){}
	public Garage(String Location){ this.location = Location; }
	public Garage(String Location, ArrayList<Vehicle> vehiclesList){
		this.location = Location;
		this.vehicles = vehiclesList;
	}
	
	////
	// Methods
	////
	
	// Gettors
	public String getLocation(){
		return this.location;
	}
	
	public ArrayList<Vehicle> getVehicleList(){
		return this.vehicles;
	}
	
	//Settors
	
	public void setLocation(String Location){
		this.location = Location;
	}
	
	public void setVehicleList(ArrayList<Vehicle> vehiclesList){
		this.vehicles = vehiclesList;
	}
	
	public void addVehicle(Vehicle v){
		this.vehicles.add(v);
	}
	
	public void removeVehiclebyID(int ID){
		for(int x = 0; x < this.vehicles.size(); x++){
			if(this.vehicles.get(x).getID() == ID){
				this.vehicles.remove(x);
				break;
			}
		}
	}
		
	public void removeVehiclebyType(String type){
		
		Iterator itr = this.getVehicleList().iterator();
		
		while(itr.hasNext()){
			if(type.equals("Car") && itr.next() instanceof Car){
				itr.remove();
			}
			if(type.equals("MotorBike") && itr.next() instanceof MotorBike){
				itr.remove();	
			}
			if(type.equals("Truck") && itr.next() instanceof Truck){
				itr.remove();
			}
		}
	}
				
}
