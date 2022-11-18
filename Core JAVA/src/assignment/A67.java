//Write a Java program to convert a hash set to an array.

package assignment;

import java.util.HashSet;

public class A67 {
		public static void main(String[] args) {
				
			HashSet set = new HashSet();
			
			set.add("Hemant");
			set.add("Kishor");
			set.add("Rudra");
			set.add("Kushal");
			set.add("Vatsal");
			
			System.out.println("HashSet : "+ set);
			
			
			String[] array=new  String[set.size()];
			set.toArray(array);
			
			System.out.println("\nArray elments : ");
			
			for(String s : array) {
				System.out.println(s);
			}
		}
}
