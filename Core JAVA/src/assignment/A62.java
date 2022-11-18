//Write a Java program to reverse elements in an array list.

package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class A62 {
	
		public static void main(String[] args) {
			
				ArrayList<String> list = new ArrayList<String>();
				list.add("Hemant");
				list.add("Kishor");
				list.add("Rudra");
				list.add("Kushal");
				list.add("Vatshal");
				System.out.println("Before Reverse Array list :   ");
				System.out.println(list);
				
				
				Collections.reverse(list);
				System.out.println("Reverse Array list :   ");
				System.out.println(list);
			
		}
}
