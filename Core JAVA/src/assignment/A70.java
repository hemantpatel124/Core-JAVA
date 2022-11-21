//Write a Java program to increase the size of an array list.

package assignment;

import java.util.ArrayList;
import java.util.Collections;

public class A70 {

		public static void main(String[] args) {
			
			ArrayList<String> list = new ArrayList<String>(2);
			list.add("Hemant");
			list.add("Kishor");
			System.out.println("Size of Array : "+list);
			
			list.ensureCapacity(5);
			
			list.add("Rudra");
			list.add("Kushal");
			list.add("Vatshal");
			
			System.out.println("After size increase Array list: "+list);
		}
}
