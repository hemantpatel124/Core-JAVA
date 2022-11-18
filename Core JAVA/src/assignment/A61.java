//Write a Java program to count the number of key-value (size) mappings in a map.

package assignment;

import java.util.HashMap;
import java.util.Map;

public class A61 {
	
		public static void main(String[] args) {
				

			HashMap<Integer,String> hmap=new HashMap<Integer,String>();
			hmap.put(1,"Hemant");
			hmap.put(2,"Kishor");
			hmap.put(3,"Sarth");
			hmap.put(4,"Rudra");
			hmap.put(5,"Kushal");
			hmap.put(6,"Vatshal");
			
			System.out.println("Size of the HashMap : "+hmap.size());
			
			
		}
}
