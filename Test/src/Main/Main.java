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
		start();
	}
	
	public static void start(){
		// go to the respected class and access it's start method.
		// the start method covers all tasks for that section.
		// start is called as part of a sections constructor.
			// Common is a parent class, but in retrospect, 
			// might function as an interface in general
		System.out.println("-----------------------------------------------------------------\n"+"Uncomment methods to access functionality.\n" + 
		"-----------------------------------------------------------------");
		Basic x = new Basic();
		Sleep(2000);
		
		Intermediate y = new Intermediate();
		Sleep(2000);
		
		Advanced z = new Advanced();
		//Sleep(2000);
		
		// My testing area for any potential design pattern - current focus: Decorator pattern.
			//Custom w = new Custom();
	}
	
}
