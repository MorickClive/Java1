package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import junit.framework.*; 


import Intermediate.Employee;
import Intermediate.Person;
import Library.Book;
import Library.Item;
import Library.Map;
import Library.Media;

public class Common {
	// some system globals
	private static boolean sleepOn = true;	
	
	// Private sleep function, aids in laying out data in timely chunks
	protected static void Sleep(int Ms)
	{	
		if(sleepOn){
			try {
		    Thread.sleep(Ms);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	protected static void Sleep(long Ms)
	{	
		if(sleepOn){
			try {
		    Thread.sleep(Ms);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	////
	// Common Functions
	////
	
	// print text
	public static void print(String text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	
	public static String helloWorld(){
		return "Hello World! \nFrom return function.";
	}
	
	//@overloads print 
	public static void print(int text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	public static void print(float text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	public static void print(double text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	
	public static void printDelayed(String text, float speed){
		char[] cha = text.toCharArray();
		
		for(int x = 0; x < cha.length; x++){
			if(cha[x] == '/' && cha[x+1] == 'n' ){ System.out.println(); }
			else{
			System.out.print(cha[x]);
			}
			Sleep((long)speed);
		}
	}
	
	public static int add(int x, int y){ return x + y;}
	public static float add(float x, float y){ return x + y;}
	
	public static int mult(int x, int y){ return x * y; }
	public static float mult(float x, float y){ return x * y; }
	
	// Advanced programming methods.
	public static void FileWriter()
	{
		File file = new File("Hello_World.txt");
		try{
				if(!file.exists())
				{
					System.out.println("File Created!!!");
					file.createNewFile();				
				}
				// Declare printer
				PrintWriter Printer = new PrintWriter(file);
				
				Printer.println("File Header:\tHello World Writer.");
				Printer.println("\n\t- Hello World!");
				// done with writing
				Printer.close();
			}	
			catch(IOException ex){
				ex.printStackTrace();			
			}
	}
	
	//@Overload Employee Writer
	public static void FileWriter(ArrayList<Employee> Employee, boolean simplify)
	{
		if(simplify){
			File file = new File("EmployeeList.txt");
			try{
					if(!file.exists())
					{
						System.out.println("File Created!!!");
						file.createNewFile();				
					}
					// Declare printer
					PrintWriter Printer = new PrintWriter(file);
					
					Employee y;
					for(int x = 0; x < Employee.size(); x++){
						y = Employee.get(x);
						Printer.print(	y.getDetails()[0] +":"+
										y.getDetails()[1] +":"+
										y.getDetails()[2] + ":");
					}
					// done with writing
					Printer.close();
				}	
				catch(IOException ex){
					ex.printStackTrace();			
				}
		}
		else{
			File file = new File("EmployeeList_Complex.txt");
			try{
				if(!file.exists())
				{
					System.out.println("File Created!!!");
					file.createNewFile();				
				}
				// Declare printer
				PrintWriter Printer = new PrintWriter(file);
				
				Printer.println("File Header:\tEmployee Writer.");
				Printer.println("Employee List:");
				Printer.println("");// pad the data
				
				for(int x = 0; x < Employee.size(); x++){
					Printer.println("Employee #" + x);
					Printer.println("\t" + Employee.get(x).getDetails()[0]);
					Printer.println("\t" +Employee.get(x).getDetails()[1]);
					Printer.println("\t" +Employee.get(x).getDetails()[2]);
					Printer.println();
				}
				// done with writing
				Printer.close();
			}	
			catch(IOException ex){
				ex.printStackTrace();			
			}
		}			
	}

	public static void FileWriter(ArrayList<Item> itm)
	{
			File file = new File("Item_list.txt");
			try{
					if(!file.exists())
					{
						System.out.println("File Created!!!");
						file.createNewFile();				
					}
					// Declare printer
					PrintWriter Printer = new PrintWriter(file);
					
					Item y;
					for(int x = 0; x < itm.size(); x++){
						y = itm.get(x);
						
						if(y instanceof Book){
							Printer.println("Type :" + "Book");
							Printer.println( ((Book)itm.get(x)).detailsBookFormated() );
							
							}
						if(y instanceof Map){
							Printer.println("Type :" + "Map");
							Printer.println( ((Map)itm.get(x)).detailsMapFormated() );
							
							}
						if(y instanceof Media){
							Printer.println("Type :" + "Media");
							Printer.println( ((Media)itm.get(x)).detailsMediaFormated() );
							}
					}
					// done with writing
					Printer.close();
				}	
				catch(IOException ex){
					ex.printStackTrace();			
				}
			
	}

	
	public static void FileReader()
	{
		BufferedReader br = null;
	
		try{
			br = new BufferedReader(new FileReader("Hello_World.txt"));
			String line;
			
			while( (line = br.readLine()) != null)
			{
				System.out.println(line);	
			}
			
			System.out.println("");
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// close the file
			try{
			br.close();
			}catch(IOException ex)
			{ex.printStackTrace();}
		}
	}

	public static void FileReader(String filename)
	{
		ArrayList<Employee> Employee = new ArrayList<>();
		BufferedReader br = null;
		HashMap hm = new HashMap();
		hm.put("Zara", new Double(3434.34));
		
		try{
			br = new BufferedReader(new FileReader(filename));
			String line;
			String[] storedLine;
			
			line = br.readLine();
			storedLine = line.split(":");
			
			int charTracker = 0;
			for(int x = 0; x < (storedLine.length / 3); x++){
				Employee.add(new Employee());
				Employee.get(x).setName(storedLine[charTracker]);
				Employee.get(x).setAge(Integer.parseInt(storedLine[charTracker +1]));
				Employee.get(x).setOccupation(storedLine[charTracker +2]);
				
				charTracker += 3;
			}
			
			for(int x = 0; x < Employee.size(); x++){
				print(	Employee.get(x).getDetails()[0] +"\n"+
						Employee.get(x).getDetails()[1] +"\n"+
						Employee.get(x).getDetails()[2] + "\n");
			}
			
			System.out.println("");
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// close the file
			try{
			br.close();
			}catch(IOException ex)
			{ex.printStackTrace();}
		}
	}

	public static ArrayList<String> FileLineReader(String filename)
	{
		ArrayList<String> myString = new ArrayList<>();
		BufferedReader br = null;
	
		try{
			br = new BufferedReader(new FileReader(filename));
			String line;
			
			while( (line = br.readLine()) != null)
			{
				myString.add(line);
			}
			
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// close the file
			try{
			br.close();
			}catch(IOException ex)
			{ex.printStackTrace();}
		}
		return myString;
	}
	
	
}