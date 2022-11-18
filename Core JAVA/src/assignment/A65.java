//Write a Java program of swap two elements in an array list.

package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A65 {
		
		public static void main(String[] args) {
			
			List<String> list1 = new ArrayList<String>();
			list1.add("Hemant");
			list1.add("Kishor");
			list1.add("Rudra");
			list1.add("Kushal");
			list1.add("Vatshal");
						
			System.out.println("\nBefore Swap elemnt Array list :");
			System.out.println(list1);
			
			
			Collections.swap(list1, 2, 3);
			System.out.println("\nAfter Swap elemnt Array list :");
			System.out.println(list1);
		}
}
