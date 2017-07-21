package Library;

import java.util.ArrayList;

public class Customer {
	
	private static int total = 0;
	private int ID = 0;
	
 private		String 	name = "MISSING",
		 		email = "N/A";
private	int 	age = 0,
				contactNo = 00000000000;
private	float	outstandingFees = 0;
	
	ArrayList<Item> borrowList = new ArrayList<>();
	
	public Customer(){total++; ID = total;}
	public Customer(String name, String email, int age, int contactNo){ 
		// Initialise total customers in existence, assign ID.
		total++; ID = total;
		
		// Initialise details
		this.name = name;
		this.email = email;
		this.age = age;
		this.contactNo = contactNo;
	}
	
	public int getID(){
		return ID;
	}
	
	public void updateDetails(String name, String email, int age, int contactNo){
		// Initialise details
		// if the value is something - bind it, else keep existing.
		this.name = 	name != null ? 
						name : this.name;
		this.email = 	email != null ?
						email : this.email;
		
		this.age =		age != 0 ?
						age : this.age;
		
		this.contactNo = contactNo != 0 ?
						 contactNo : this.contactNo;
	}
	
	
	public float getOutstandingFees() {
		return outstandingFees;
	}
	public void setOutstandingFees(float outstandingFees) {
		this.outstandingFees = outstandingFees;
	}
	public ArrayList<Item> getBorrowList() {
		return borrowList;
	}
	public void setBorrowList(ArrayList<Item> borrowList) {
		this.borrowList = borrowList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
}
