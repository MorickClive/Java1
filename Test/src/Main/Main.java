package Main;

import java.util.ArrayList;
import java.util.Random;

import Common.Advanced;
import Common.Basic;
import Common.Common;
import Common.Custom;
import Intermediate.Intermediate;
import Library.*;

public class Main extends Common {

	public static void main(String[] args) {
		//Basic x = new Basic();
		//Sleep(2000);
		
		Intermediate y = new Intermediate();
		//Sleep(2000);
		
		//Advanced z = new Advanced();
		//Sleep(2000);
		
		//Custom w = new Custom();
		
		start();
	}
	
	public static void start(){
		Library libSystems = new Library("Manchester's Library", 1843);
		
		// Add in books.
		libSystems.addItem(new Book("The Wonders of Seashells", "Paper", "Adventure", true) );
		libSystems.addItem(new Media("Digital Soundtrack: Flickswitch (2010)", "Plastic", "A soundtrack from a popular scifi film, released in 2010. Electronic, Drums and Bass."));
		libSystems.addItem(new Map("Atlas of Germany", "Paper", "Germany", "English") );
		libSystems.addItem(new Book("Chuckles trip", "Paper", "Action", true) );
	

		// Add in customers
		libSystems.customerRegister(new Customer("Dave", null, 74, 0));
		libSystems.customerRegister(new Customer("Ian", null, 29, 0));
		libSystems.customerRegister(new Customer("Patrick", null, 17, 0));
		libSystems.customerRegister(new Customer("Sarah", "Sarah.G1@TTQindustries.com", 35, 0));
		
		// lists
		ArrayList<Item> libList = libSystems.getItemSections();
		ArrayList<Customer> libCustList = libSystems.getCustomerList();
		
		//BAD DAVE!
			//libCustList.get(0).setOutstandingFees(libSystems.getLateFee());
		// ERROR, SYSTEM FAILURE
			//libSystems.getItemSections().get(3).setLoaned(true);
		// SUPER BAD DAVE
			///libSystems.checkOutItem(libList.get(2), libCustList.get(0));
			///libSystems.checkOutItem(libList.get(1), libCustList.get(0));
			///libSystems.checkOutItem(libList.get(0), libCustList.get(0));
		
		libSystems.checkOutItem(libList.get(3), libCustList.get(0));
		
		libSystems.checkInItem(libList.get(3));
//		 Map map23 = (Map) libList.get(2);
//		((Map) libList.get(2)).updateItem("Atlas of Denmark", "Plastic", 0, "Denmark", "German");
		
//		for(int x = 0; x < libList.size(); x++){
//			System.out.println("Item ID: " + libList.get(x).getID());
//			System.out.println("Item Title: " + libList.get(x).getTitle());
//		}
	}

}
