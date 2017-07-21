package Intermediate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import Common.Common;

public class Intermediate extends Common  {

	public Intermediate()
	{
		Start();
	}
	
	static void Start(){
		print("This is the Intermediate section.\n");
		
		//print(blackJack(18,21)); // -- backjack
		//print(blackJack(20,18)); // -- ^^
		//print(blackJack(22,22)); // -- ^^
		
		//print(uniqueSum(1,2,3)); // -- UniqueSum
		//print(uniqueSum(3,3,3)); // -- ^^
		//print(uniqueSum(1,1,2)); // -- ^^
		
		// --  TOO HOT (or too cold; it really doesn't discern cold too well).
		/* 
		print(tooHot(90, false) ? 
				"True" :
				"False");
		 */
		
		//people(); //-- Person class
		//garageTest(); //-- Garage and Vehicle class
		//Sleep(500);
		
		//paintWizard();
		//Sleep(500);
		
		//writeEmployeeList();
		//Sleep(500);
		
		print("Intermediate tasks are over.\n\n");
	}

	public static int blackJack(int x, int y){
		
		int bjk = 21;
		
		if(x <= bjk && y <= bjk){
			// if the value of x is less than b when compared to 21.
			// where a and b are the distance/value away from 21.
			int a = bjk - x, b = bjk - y;
			return a <= b ? x : y;
		}
		else{
			return 0;
		}	
	}

	public static int uniqueSum(int x, int y, int z){
		int sum = 0;
		int[] val = new int[3];
		
		val[0] = x == y || x == z ? 0 : x;
		val[1] = y == x || y == z ? 0 : y;
		val[2] = z == x || z == y ? 0 : z;
		
		sum = val[0] + val[1] + val[2];
		
		return sum;
	}

	public static boolean tooHot(int temp, boolean isSummer){
		if(isSummer){
			return temp >= 100 || temp <= 60;
		}
		else{
			return temp >= 90 ||  temp <= 60;
		}
	}
	
	static void jTest(){
	}
	
	static void people(){
		ArrayList<Person> people = new ArrayList<>();
		
		people.add(new Person("Elis", 		25, "Car Mechanic"));
		people.add(new Person("Charlotte", 	23, "Receptionist"));
		people.add(new Person("John", 		32, "Sales Manager"));
		people.add(new Person("Maxwell",	53, "Business Executive"));
		people.add(new Person("James",		25, "Graphic Designer"));
		
		for(int x = 0; x < people.size(); x++){
			System.out.println("Person #" + x);
			people.get(x).getDetails();
			System.out.println();
		}
	}
	
	static void garageTest(){
		Garage meinGarage = new Garage();
		ArrayList<Vehicle> VehicleList = meinGarage.getVehicleList();
		
		// We'll store the price in here.
		float totalSum = 0;
		
		VehicleList.add(new Car("Volvo", "Large", 4, 3500, 8, "Manual"));
		VehicleList.add(new Car("Jaguar", "Medium", 4, 66000, 6, "Manual"));
		VehicleList.add(new Car("Renault", "Small", 4, 750, 6, "Automatic"));
		VehicleList.add(new MotorBike("Norton", "Small", 2, 2500, "Small"));
		VehicleList.add(new MotorBike("Harley-Davidson", "Medium", 2, 65000, "Large"));
		VehicleList.add(new Truck("Norton", "Small", 2, 2500, true));
		VehicleList.add(new Truck("Harley-Davidson", "Medium", 2, 65000, false));
		
		// Removal of a vehicle
		Vehicle removedVehicle = VehicleList.get(2);
		VehicleList.remove(2); // removes
		//Store deleted types
		meinGarage.removeVehiclebyType("Truck");
		
		for(int x = 0; x < VehicleList.size(); x++){
			System.out.println("Vehicle ID: " + VehicleList.get(x).getIDformatted());
			VehicleList.get(x).getDetails();
			System.out.println("\n");
			
			totalSum += VehicleList.get(x).getPrice();
			Sleep(1000); 
		}
		
		// Post the removed vehicle
		System.out.println("Removed Vehicle Section:");
		System.out.println("\tThe removed vehicle was the: " + removedVehicle.getModel() + ".\n\tID Number: " + removedVehicle.getIDformatted() +"\n");
				
		// Clear out the garage.
		System.out.println("Now clearing out the Garage...");
		VehicleList.clear(); // should clear the array
		System.out.println(VehicleList.size() <= 0 ? 
							"\tThe Garage is now empty!!" :
							"\tThe garage still has " + VehicleList.size() + " vehicles left.");
		System.out.println("");
		
		
		// Declare total worth of all vehicles in the garage.
		System.out.println("The total value of all vehicles in the Garage is equal to: £ "+ totalSum );
	}

	static void paintWizard(){
		// Our paints, respective index locations.
		String[] Brand = 		{"CheapoMax", "Averagejoes", "DuluxourousPaints"};
		int[] Litre = 			{20, 15, 10};
		int[] coverageRate = 	{10, 11, 20}; // m^2 per litre
		float[] Price = 		{19.99f, 17.99f, 25.00f};
		
		
		// Storage values
		String BestValueBrand = null, BestCoverageBrand = null;
		float BestVal = 0, BestCoverage = 0;
		
		// Calculate for every brand
		for(int x = 0; x < Brand.length; x++){
			if( BestVal < (Price[x] / Litre[x]) /coverageRate[x]){
				BestValueBrand = Brand[x];
				BestVal = Litre[x] / Price[x];
			}
			
			if( BestCoverage <  Litre[x] /coverageRate[x]){
				BestCoverageBrand = Brand[x];
				BestCoverage = Litre[x] /coverageRate[x];
			}
			
		}
		
		// report finds
		print( "The best brand for coverage is: " + BestCoverageBrand + ",\n" +
							"At the coverage rate of: " + BestCoverage + "m^2." + "\n");
		
		print( "The best brand for price is: " + BestValueBrand + ",\n" +
							"At the value to litre rate of: £ " + String.format("%1.2f", BestVal) + ".");
		
		System.out.println();
	}
	
	static void writeEmployeeList(){
		// Write the array
		ArrayList<Employee> Employee = new ArrayList<>();
		
		// Populate array
		Employee.add(new Employee("Elis", 		25, "Car_Mechanic"));
		Employee.add(new Employee("Charlotte", 	23, "Receptionist"));
		Employee.add(new Employee("John", 		32, "Sales_Manager"));
		Employee.add(new Employee("Maxwell",	53, "Business_Executive"));
		Employee.add(new Employee("James",		25, "Graphic_Designer"));
		
		// Send array data out
		FileWriter(Employee, false);
		
		FileReader("EmployeeList.txt");		
		
	}
	
}

