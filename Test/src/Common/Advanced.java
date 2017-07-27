package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import BattleShip.BattleShips;

public class Advanced extends Common {

	public Advanced()
	{
		Start();
	}
	
	static void Start(){
		print("This is the Advanced section.\n");
		// uncomment methods to access functionality
		
		// PrimeNumber test
			//primeNumbers(1000000);
		// HashMap
			//hashScope();
		
		// Task BattleShips
			//BattleShips x = new BattleShips();
		
		print("Advanced tasks are over.\n\n");
	}
	
	static boolean primeTest(float n){
		if(n <= 1){	return false;}
		
		for(int i = 2; i <= Math.pow(n, 0.5f); i++ ){
			if( n % i == 0){
				return false;
			}
		}
		
		return true;
	}
	
	static void primeNumbers(float upperLimit){
		
		int count = 0;
		Timer t = new Timer();
		
		t.startTimer("Prime number Timer.");
		
		System.out.println("--- Prime Number test ---");
		// consider applying the process into a multi-threaded environment to boost performance
		for(int x = 0; x < upperLimit; x++){
				count += primeTest(x) ? 1 : 0;
		}
		print("Then number of prime numbers within " + upperLimit + ", is " + count + ".");
		System.out.println("--- Prime Number test done!! ---");
		t.stopTimer();
		System.out.println("ms: " +t.time);
	}

	static void hashScope(){
		// Get our data in
		ArrayList<String> fileData = FileLineReader("DOG_CLASS.txt"); // is an Animal, maybe; x.bark(); (PS: is the word list file)
		char[] y; // prepare for sorting without initialising every loop.
		ArrayList<String> fileDataSorted = new ArrayList<>(); // I need a seperate list, but I can terminate the non-sorted list to free up data.
		LinkedHashMap<String, Integer> hashmap = new LinkedHashMap<>(); // my values need to conform a hashmap type, this will allow me to utilise the benefits of this method of data storage.
		
		// How big is our word list?
			System.out.println("Read in: " + fileData.size() + " words in list.");
		// Let's convert the data to a sorted format.
			// exposing the anagram.
			for(int x = 0; x < fileData.size(); x++){
				y = fileData.get(x).toLowerCase().toCharArray();
				Arrays.sort(y);
				fileDataSorted.add(new String(y));
			}
		// fileDataSorted makes fileData redundant - let's flush
			fileData.clear();
	
			
			System.out.println("2nd loop: HashMap insertion.");
		
		// record how many instances of an anagram exists, store with the value associated.
			for(int x = 0; x < fileDataSorted.size(); x++){
				if(hashmap.containsKey(fileDataSorted.get(x))){
					hashmap.put(fileDataSorted.get(x),  hashmap.get(fileDataSorted.get(x)) +1);
				}else{
					hashmap.put(fileDataSorted.get(x), 0);
				}
				
			}
		// how big is our hashmap
			System.out.println("HashMap size: " + hashmap.size() + " Entries.");
			System.out.println();	
		// Find the sample which has the highest value
			Set set = hashmap.entrySet();
			Iterator i = set.iterator();
			Map.Entry sample;
		
			int TopVal = 0;
			String ID = "";
			
			while(i.hasNext()){
				sample = (Map.Entry)i.next();
				// print(	sample.getKey() + " : "+ sample.getValue());
				if ((int)sample.getValue() >= TopVal){
					ID = (String)sample.getKey(); TopVal = (int)sample.getValue();
				}
			}
			System.out.println("ID: " + ID + ", val: " + TopVal);

		// top value found
			System.out.println();
		
	}
}


// element from Elliot's code sample.
	class Timer {
		public double time;
		public String message;
	
		public Timer(){}
		
		public void startTimer(String message) {
			this.message = message;
			this.time = System.currentTimeMillis();
			System.out.println("Started: " + this.message);
		}
		public void stopTimer() {
			double time = (System.currentTimeMillis() - this.time);
			System.out.println("Finished: " + this.message + " In: " + time);
		}
	}

/*
 function primeTest(x)

local primes = {}

for i= 1, x,1 do
	test(i, primes) -- can return bools
end

print("primes captured:")
printTable(primes)

end
 */


