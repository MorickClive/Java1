package Intermediate;

public class Person {
	private String Name = "MISSING";
	private int Age = 0;
	private String jobTitle = "MISSING";
	
	////
	// Constructor
	////
	public Person(){
	}
	
	// Overload
	public Person(String Name, int Age, String jobTitle){
		this.Name = Name;
		this.Age = Age;
		this.jobTitle = jobTitle;
	}
	
	////
	// Methods
	////
	// gettors and setters
	String getName(){
		return Name;
	}
	
	int getAge(){
		return Age;
	}
	
	String getJobtitle(){
		return jobTitle;
	}
	
	void setName(String x){ this.Name = x;}
	void setAge(int x){	this.Age = x;}
	void setJobtitle(String x){	this.jobTitle = x;}
	
	// methods.
	
	public void getDetails(){
		System.out.print("Name: " + getName() +
						 "\nAge: " + getAge() +
						 "\nJob Title: '" + getJobtitle() +
						 "'\n");
	}
}
