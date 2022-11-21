//Write a Java program to compare two sets and retain elements which are same on both sets.

package assignment;

import java.util.HashSet;

public class A73 {
		
		public static void main(String[] args) {
				
			HashSet<String> set = new HashSet<String>();
			set.add("Hemant");
			set.add("Kishor");
			set.add("TOPS");
			set.add("Kushal");
			set.add("Vatshal");
			System.out.println("First HashSet : " +set);
			
			HashSet<String> set2 = new HashSet<String>();
			set2.add("Hemant");
			set2.add("Akash");
			set2.add("TOPS");
			set2.add("Sarth");
			set2.add("Vipul");
			System.out.println("Second HashSet : " +set2);
			
			
			set.retainAll(set2);
			System.out.println("\nAfter compare two set  retain elements : ");
			System.out.println(set);
			
		}
}
