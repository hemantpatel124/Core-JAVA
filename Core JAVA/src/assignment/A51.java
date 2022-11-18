//Write a Java program to update specific array element by given element.

package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class A51 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Hemant");
		list.add("Kishor");
		list.add("Rudra");
		list.add("Kushal");
		list.add("Vatshal");
		
		System.out.println("Elements of Arraylist : ");
		System.out.println(list);
		
		list.set(2, "Akash");
		System.out.println("\nAfter update Array list :  ");
		System.out.println(list);
	
	}
}
