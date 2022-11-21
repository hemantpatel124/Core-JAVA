//Write a Java program to replace the second element of an Array List with the specified element.

package assignment;

import java.util.ArrayList;

public class A71 {
	
		public static void main(String[] args) {
			
			ArrayList<String> list = new ArrayList<String>(2);
			list.add("Hemant");
			list.add("Kishor");
			list.add("Rudra");
			list.add("Kushal");
			list.add("Vatshal");
			
			
			System.out.println("Array List : "+list);
			
			list.set(1, "TOPS");
			
			System.out.println("After second element replace array list : ");
			System.out.println(list);
		}
}
