package Common;

import java.util.Random;

public class Basic extends Common {

	
	public Basic(){
		start();
	}
	
	public void start(){
		print("This is the Basics section.\n");
		// -- hello world section
			//print("Hello World!"); 
			//System.out.println(helloWorld());
			//print(add(2,5));
		
		// conditional checks
		//print(condiChecks(5, 5, true)); // -- conditional 1
		//print(condiChecks(5, 5, false)); //-- conditional 1
		//print(condiChecks(6, 0, false)); //-- conditionals 2
		
		//iteration(); // -- iteration
		
		//Array();// arrays	
		print("Basics are done.\n\n");
	}
	
	

	static float condiChecks(float x, float y, boolean z){
		// check if we have any unacceptable values.
		if( x <= 0 || y <= 0){
			String msg = " is the only positive value: ";
			print(x <= 0 ? "y"+msg + y :"x"+msg +x);
		}
		
		// if true, add, else. multiply.
		if(z == true){
			return add(x,y);
		}
		else{
			return mult(x,y);
		}
	}

	static void iteration(){
		Random generator = new Random();
		generator.setSeed(34344);
		for(int x = 1; x <= 10; x++){
			print("iteration: " + x);
			System.out.print("\t");
			// don't look; you'll go blind
			print("\t" + condiChecks((float) Math.random()* 10,
									  Math.random() * 1 < 0.5f ? 0 : (float) Math.random() * 10,
									 (Math.random() * 1 < 0.5f ? true : false)
									 )
				);
		}	
	}
	
	// overloads
	static void iteration(int[] xlist){
		for(int x = 0; x < xlist.length; x++ ){
			print(xlist[x]);
		}
	}

	static void Array(){
		int[] myList =  new int[10];
		
		for(int x = 0; x < myList.length; x++){
			myList[x] = (int) (x * Math.pow(x, 2));
		}
		
		iteration(myList);
	}

	
}
