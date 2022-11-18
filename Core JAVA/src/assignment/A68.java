//Write a Java program to convert a hash set to a List/Array List.

package assignment;

import java.util.*;
import java.util.HashSet;

public class A68 {
		
		public static void main(String[] args) {
				
			HashSet<String> set = new HashSet<String>();
			set.add("Hemant");
			set.add("Kishor");
			set.add("Rudra");
			set.add("Kushal");
			set.add("Vatshal");
			
			System.out.println("HashSet : "+set);
			
			
			List<String> list =new ArrayList<String>(set);
			System.out.println("Array List : "+list);
			
		
		}
}
