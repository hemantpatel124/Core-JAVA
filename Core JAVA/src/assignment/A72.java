//Write a Java program to print all the elements of an Array List using the position of the elements.

package assignment;

import java.util.ArrayList;

public class A72 {
	
		public static void main(String[] args) {
				
			ArrayList<String> list = new ArrayList<String>(2);
			list.add("Hemant");
			list.add("Kishor");
			list.add("Rudra");
			list.add("Kushal");
			list.add("Vatshal");
			
			System.out.println("Array list : "+list);
			
			
			System.out.println("\nUsing position elements array List : ");
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
}
