//Write a Java program to check whether a map contains key-value mappings (empty) or not.


package assignment;

import java.util.HashMap;
import java.util.Map;

public class A69 {
	
		public static void main(String[] args) {
			
			HashMap<Integer,String> hmap=new HashMap<Integer,String>();
			hmap.put(1,"Hemant");
			hmap.put(2,"Kishor");
			hmap.put(3,"Sarth");
			hmap.put(4,"Rudra");
			hmap.put(5,"Kushal");
			hmap.put(6,"Vatshal");
			
			
			System.out.println("HashMap empty : "+hmap.isEmpty());
			
			hmap.clear();
			System.out.println("HashMap empty : "+hmap.isEmpty());
		}
}
