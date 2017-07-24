package Advanced;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Intermediate.Intermediate;
import Library.Book;
import Library.Customer;
import Library.Item;
import Library.Library;
import Library.Map;
import Library.Media;
import junit.framework.TestCase;

public class example {

//	Input(18,21) -> 21
//	Input(20,18) -> 20
//	Input(22,22) -> 0

	@Test
	public void test_BlackJack_1(){
		Intermediate y = new Intermediate();
		
		TestCase.assertEquals(21, y.blackJack(18,21));
	}
	
	@Test
	public void test_BlackJack_2(){
		Intermediate y = new Intermediate();
		
		TestCase.assertEquals(20, y.blackJack(20,18));
	}
	
	@Test
	public void test_BlackJack_3(){
		Intermediate y = new Intermediate();
		
		TestCase.assertEquals(0, y.blackJack(22,22));
	}

// Unique Sum test
//	Input(1,2,3) -> 6
//	Input (3,3,3) -> 0
//	Input (1,1,2) -> 2
	
	@Test
	public void test_UniqueSum_1(){
		Intermediate y = new Intermediate();
		
		TestCase.assertEquals(6, y.uniqueSum(1,2,3));
	}
	
	@Test
	public void test_UniqueSum_2(){
		Intermediate y = new Intermediate();
		
		TestCase.assertEquals(0, y.uniqueSum(3,3,3));
	}
	
	@Test
	public void test_UniqueSum_3(){
		Intermediate y = new Intermediate();
		
		TestCase.assertEquals(2, y.uniqueSum(1,1,2));
	}

// in range
// out range
// in range, in summer
// out range, in summer
	
	@Test
	public void tst_TooHot_1(){
		Intermediate y = new Intermediate();
		TestCase.assertEquals( false, y.tooHot(70, false) );
		
		// isSummer - 60-90
		// !isSummer - 60-100
	}
	
	@Test
	public void test_TooHot_2(){
		Intermediate y = new Intermediate();
		TestCase.assertEquals( true, y.tooHot(95, false) );
		
		// isSummer - 60-90
		// !isSummer - 60-100
	}
	
	@Test
	public void test_TooHot_3(){
		Intermediate y = new Intermediate();
		TestCase.assertEquals( false, y.tooHot(70, true) );
		
		// isSummer - 60-90
		// !isSummer - 60-100
	}
	
	@Test
	public void test_TooHot_4(){
		Intermediate y = new Intermediate();
		TestCase.assertEquals( true, y.tooHot(110, true) );
		
		// isSummer - 60-90
		// !isSummer - 60-100
	}
	
	@Test
	public void test_Library_1(){
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
			libSystems.checkOutItem(libList.get(0), libCustList.get(0));
			libSystems.checkOutItem(libList.get(1), libCustList.get(0));
			libSystems.checkOutItem(libList.get(2), libCustList.get(0));
			
		libSystems.checkOutItem(libList.get(3), libCustList.get(0));
		
		libSystems.checkInItem(libList.get(3));
		
		libCustList.get(0).getAccountOverview();
	}

}
