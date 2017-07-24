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
		if(Object instanceof Book && sampleObject instanceof Book){ 	((Book)Object).updateItem(	sampleObject.getTitle(),
																	sampleObject.getItem_Type(),
																	sampleObject.getMaterial(),
																	sampleObject.getPrice());}
//		String title, String material, int price, String location, String language
		if(Object instanceof Map && sampleObject instanceof Map){		((Map)Object).updateItem(	sampleObject.getTitle(),
																	sampleObject.getItem_Type(),
																	sampleObject.getPrice(),
																	((Map)sampleObject).getLocation(),
																	((Map)sampleObject).getLanguage());}
//		String title, String item_Type, String material, int price, String description
		if(Object instanceof Media && sampleObject instanceof Media){	((Media)Object).updateItem(	sampleObject.getTitle(),
																	sampleObject.getItem_Type(),
																	sampleObject.getMaterial(),
																	sampleObject.getPrice(),
																	((Media)sampleObject).getDescription());}
		//if()
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
					System.out.println("You are unable to borrow books at this time.");
					System.out.println("We're sorry but this item hasn't been checked back into the system yet.");
					System.out.println("Please hand this item back to the receiptionist to check out.\n");
				}
			}
			else{
				// We have too many books!!
				System.out.println("You are unable to borrow more books at this time.");
				
				System.out.println("\t"+"You currently have " + cstmr.getBorrowList().size() + " books registered on your account.\n");
				
			}
		}
		else{
		
			System.out.println("You are unable to borrow books at this time.");
			
			System.out.println("\t"+"Unfortunately your account is marked with a £" + cstmr.getOutstandingFees() + " late fee." + "\n\t" +
								"Please see the receptionist to clear the late fee.\n");
		}
	}

	public void checkInItem(Item itm){
		
		Customer lender = itm.returnOwner(customerList);
		
		if(itm.getCustomer_ID() != 0){
			// Here I would check if the date received matches the date range I can work with.
			itm.updateLoan(0); // the book now technically has no days out of library.
			itm.setLoaned(false); // no longer loaned
			
			// Check through our custonmer's borrow list and remove the book in question.
				// The size of the array now should reflect the change - allowing for new book removals.
	
			for(int x = 0; x < lender.getBorrowList().size(); x++){
				if(lender.getBorrowList().get(x).ID == itm.getID()) {
					// remove this book from their collection!!
					// System.out.println("The book '"+ lender.getBorrowList().get(x).getTitle() +"' has been found and removed."); // debug
					lender.getBorrowList().remove(x);
					break;
					}
			}
			
			System.out.println("Thank you for returning: '"+itm.getTitle()+"'.\n" + getCustomer(itm.getCustomer_ID()).getName() + "'s account has now been updated.\n");
			lender.getAccountOverview();
		}
		else{ 
			// This book is unowned, please put it back or check it out.
			System.out.println("This book is not owned by any account, please place the book on a service collection trolley.");
			System.out.println("Alternatively check this book out with the check out option.\n");
			}
				
	}

}
