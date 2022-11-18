//Write a Java program to copy one array list into another.

package assignment;

import java.util.ArrayList;
import java.util.Collections;

public class A55 {
	
		public static void main(String[] args) {
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("Hemant");
			list.add("Kishor");
			list.add("Rudra");
			list.add("Kushal");
			list.add("Vatshal");
			System.out.println("\nBefore Copy Array list :   ");
			System.out.println("List1 : "+list);
			
			ArrayList<String> list2=new ArrayList<String>();
			list2.add("H");
			list2.add("K");
			list2.add("R");
			list2.add("K");
			list2.add("V");
			System.out.println("List2 : "+list2);
			
			
			Collections.copy(list, list2);
			System.out.println("\nAfter Copy Array list :   ");
			
			System.out.println("List1 : "+list);
			System.out.println("List2 : "+list2);
		}
}
