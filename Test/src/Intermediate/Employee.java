package Intermediate;

public class Employee {

	private String Name, Occupation;
	private int Age;
	
	public Employee(){}
	public Employee(String Name, int Age, String Occupation){
		this.setName(Name);
		this.setOccupation(Occupation);
		this.setAge(Age);
	}
	
	////
	// Methods
	////
	
	// Settors and gettors
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getOccupation() {
		return Occupation;
	}
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	
	// functions
	public String[] getDetails() {
		String[] value = {
				getName(),
				Integer.toString(getAge()),
				getOccupation()};
		
		return 	value;
	}
	
}
