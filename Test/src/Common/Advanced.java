package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

		//primeNumbers(1000);
		//hashScope();
		
		BattleShips x = new BattleShips();
		
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
		
		System.out.println("--- Prime Number test ---");
		// consider applying the process into a multi-threaded environment to boost performance
		for(int x = 0; x < upperLimit; x++){
				count += primeTest(x) ? 1 : 0;
		}
		print("Then number of prime numbers within " + upperLimit + ", is " + count + ".");
		System.out.println("--- Prime Number test done!! ---");
	}

	static void hashScope(){
		ArrayList<String> fileData = FileLineReader("WordSort.txt");
		char[] y;
		for(int x = 0; x < fileData.size(); x++){
			
			y = fileData.get(x).toLowerCase().toCharArray();
			Arrays.sort(y);
			System.out.println(new String(y));
		}
		
		System.out.println();
		
		LinkedHashMap  x = new LinkedHashMap();
		
		x.put("Monday", 6.5f);
		x.put("Tuesday", 7.5f);
		x.put("Wednesday", 7.5f);
		x.put("Thursday", 7.5f);
		x.put("Friday", 6.5f);
		x.put("Saturday", 0f);
		x.put("Sunday", 0f);
		
		Set set = x.entrySet();
		
		Iterator i = set.iterator();
		
		while(i.hasNext()){
			Map.Entry sample = (Map.Entry)i.next();
			//System.out.print(sample.getKey() + ": ");
			printDelayed(	sample.getKey() + ": "+ sample.getValue() +
							" hours.\n", 125);
			Sleep(500);
			
		}
		System.out.println();
		
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


