//Write a Java program to get the number of elements in a hash set.

package assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class A59 {
	
		public static void main(String[] args) {
			
			HashSet<String> set = new HashSet<String>();
			set.add("Hemant");
			set.add("Kishor");
			set.add("Rudra");
			set.add("Kushal");
			set.add("Vatshal");
			
			System.out.println("Number of element in HashSet : "+set.size());
		
		}
}
