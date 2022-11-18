//Write a Java program to extract a portion of an array list.

package assignment;

import java.util.*;
import java.util.Collections;

public class A63 {
	
		public static void main(String[] args) {
			
			List<String> list = new ArrayList<String>();
			list.add("Hemant");
			list.add("Kishor");
			list.add("Rudra");
			list.add("Kushal");
			list.add("Vatshal");
			System.out.println("Array list :   ");
			System.out.println(list);
			
			
			List<String> list1=list.subList(0, 2);
			System.out.println("\nExtract Array list :   ");
			System.out.println(list1);
			
		}
}
