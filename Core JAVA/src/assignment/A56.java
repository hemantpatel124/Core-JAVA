//Write a Java program to shuffle elements in an array list.

package assignment;

import java.util.ArrayList;
import java.util.Collections;

public class A56 {
	
		public static void main(String[] args) {
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("Hemant");
			list.add("Kishor");
			list.add("Rudra");
			list.add("Kushal");
			list.add("Vatshal");
			System.out.println("\nBefore shuffle Array list :   ");
			System.out.println("List : "+list);
			
			Collections.shuffle(list);;
			System.out.println("\nAfter shuffle Array list :   ");
			
			System.out.println("List: "+list);
		}
}
