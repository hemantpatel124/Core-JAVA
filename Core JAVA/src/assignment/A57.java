//Write a Java program to append the specified element to the end of a hash set.

package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class A57 {
	
	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		set.add("Hemant");
		set.add("Kishor");
		set.add("Rudra");
		set.add("Kushal");
		set.add("Vatshal");
		
		System.out.println("Hash set is : "+set);
	}
	
}
