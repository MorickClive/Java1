package Library;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import Intermediate.*;

public class Library {
	String name = null; // Our library is called
	int yearEstablished; // this library, proudly opened in xxxx
	float lateFee = 1.50f; // per day, associated with ramp up values for key periods.
	int rentLimit = 3;

	private ArrayList<Item> ItemSections = new ArrayList<>();
	private ArrayList<Customer> customerList = new ArrayList<>();
	
	public Library(){}
	public Library(String name, int yearEst){
		this.name = name;
		this.yearEstablished = yearEst;		
	}
	
	////
	// Methods
	////
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYearEstablished() {
		return yearEstablished;
	}
	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}
	
	public ArrayList<Item> getItemSections() {
		return ItemSections;
	}
	public void setItemSections(ArrayList<Item> itemSections) {
		ItemSections = itemSections;
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	public float getLateFee() {
		return lateFee;
	}
	public void setLateFee(float lateFee) {
		this.lateFee = lateFee;
	}

	////
	// Behaviour
	///
	
	// Item behaviour
	public void addItem(Item x){
		ItemSections.add(x);		
	}
	public void removeItem(int ID){
		for(int x = 0; x < ItemSections.size(); x++){
			if(ItemSections.get(x).getID() == ID){
				ItemSections.remove(x); 
				break;
			}	
		}
	}
	
	public void updateItem(int ID, Item sampleObject){
		
		// Run through list, ID all customers, find respective ID - remove.
		for(int x = 0; x < ItemSections.size(); x++){
			if(ItemSections.get(x).getID() == ID){
				updateItem_objhandler(ItemSections.get(x), sampleObject); // takes type and casts it, updating item with respective function.
				System.out.println("Customer ID: " + ID + " details have been updated!");
				break;
			}
		}
	}	
	
	public void updateItem_objhandler(Item Object, Item sampleObject){
//		(String title, String material, int price, String genre, boolean isHardback)
		if(Object instanceof Book){ 	((Book)Object).updateItem(	sampleObject.getTitle(),
																	sampleObject.getItem_Type(),
																	sampleObject.getMaterial(),
																	sampleObject.getPrice());}
//		String title, String material, int price, String location, String language
		if(Object instanceof Map){		((Map)Object).updateItem(	sampleObject.getTitle(),
																	sampleObject.getItem_Type(),
																	sampleObject.getPrice(),
																	((Map)sampleObject).getLocation(),
																	((Map)sampleObject).getLanguage());}
//		String title, String item_Type, String material, int price, String description
		if(Object instanceof Media){	((Media)Object).updateItem(	sampleObject.getTitle(),
																	sampleObject.getItem_Type(),
																	sampleObject.getMaterial(),
																	sampleObject.getPrice(),
																	((Media)sampleObject).getDescription());}
		}
	
	// Customer behaviour
	public void customerRegister(Customer customer){
		customerList.add(customer);
		System.out.println("Customer ID: " + customer.getID() + " has been added to the system!"+"\n");
	}
	public void customerUpdate(int ID, String name, String email, int age, int contactNo){
		// Run through list, ID all customers, find respective ID - remove.
		for(int x = 0; x < customerList.size(); x++){
			if(customerList.get(x).getID() == ID){
				customerList.get(x).updateDetails(name, email, age, contactNo);
				System.out.println("Customer ID: " + ID + " details have been updated!");
				break;
			}
		}
	}
	public void customerDel(int ID){
		// Run through list, ID all customers, find respective ID - remove.
		for(int x = 0; x < customerList.size(); x++){
			if(customerList.get(x).getID() == ID){
				customerList.remove(x);
				System.out.println("Customer ID: " + ID + " has been deleted fromt the system!");
				break;
			}
		}
	}

	public Customer getCustomer(int ID){
		
		for(int x = 0; x < customerList.size(); x++){
			if(customerList.get(x).getID() == ID){
				return customerList.get(x);
			}
		}
		
		return null; // error
	}

	
	// Library behaviour
	
	public void checkOutItem(Item itm, Customer cstmr){
		
		// Check if we should allow borrowing.
		if(cstmr.getOutstandingFees() <= 0){
			// check if user has too many books out currently
			if(cstmr.getBorrowList().size() < rentLimit ){
				if(!itm.isLoaned()){
					// assign book to customer and declare loaned.
					itm.setLoaned(true);
					itm.setCustomer_ID(cstmr.getID());
					cstmr.getBorrowList().add(itm);
					
					// inform user
					System.out.println("The following item has been registered.");
					System.out.println("------------------------------------");	
					System.out.println(	"\tItem ID: " + itm.getID() + "\n" +
										"\t\tItem Title: " + itm.getTitle() + "\n" +
										"\t\tBorrowing user: " + cstmr.getID());
					
					System.out.println("------------------------------------");	
					System.out.println("This item is due back on: " + itm.getMaxLoan() + " days."); // this will be a date rather than a value.
					System.out.println("------------------------------------");	
					System.out.println(); // buffer feed
				}
				else{
					// This book has not been checked in yet
					System.out.println("We're sorry, but this item hasn't been checked back into the system yet.\n");
					System.out.println("\t"+"Please hand this item to the receiptionist to check out.");
				}
			}
			else{
				// We have too many books!!
				System.out.println("You are unable to borrow books at this time.");
				
				System.out.println("\t"+"You currently have " + cstmr.getBorrowList().size() + " books registered on your account.");
				
			}
		}
		else{
		
			System.out.println("You are unable to borrow books at this time.");
			
			System.out.println("\t"+"Unfortunately your account is marked with a £" + cstmr.getOutstandingFees() + " late fee." + "\n\t" +
								"Please see the receptionist to clear the late fee.");
		}
	}

	public void checkInItem(Item itm){
		
		// Here I would check if the date received matches the date range I can work with.
		System.out.println("Thank you for returning: '"+itm.getTitle()+"'.\n" + getCustomer(itm.getCustomer_ID()).getName() + "'s account has now been updated.");
		
		itm.updateLoan(0, null);
		// MUST SET TO FREE
		itm.setLoaned(false); // no longer loaned
				
	}

}
