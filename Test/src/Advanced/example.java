package Advanced;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Intermediate.Intermediate;
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

}
