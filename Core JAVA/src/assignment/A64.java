//Write a Java program to compare two array lists.

package assignment;

import java.util.ArrayList;
import java.util.List;

public class A64 {
		public static void main(String[] args) {
			
			List<String> list1 = new ArrayList<String>();
			list1.add("Hemant");
			list1.add("Kishor");
			list1.add("Rudra");
			list1.add("Kushal");
			list1.add("Vatshal");
			
			List<String> list2 = new ArrayList<String>();
			list2.add("Hemant");
			list2.add("Kishor");
			list2.add("Rudra");
			list2.add("Kushal");
			list2.add("Vatshal");
			
			
			System.out.println("First Array List : "+list1);
			System.out.println("Second Array List : "+list2);
			
			
			System.out.println("Compare tow array = "+list1.equals(list2));
			
			
			System.out.println("\nAdd new elment in second array list : ");
			list2.add("Sarth");
			System.out.println("After new element add");
			System.out.println("Compare tow array = "+list1.equals(list2));
		}
}
