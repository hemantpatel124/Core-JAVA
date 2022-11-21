//Write a Java program to get a collection view of the values contained in this map.

package assignment;

import java.util.HashMap;
import java.util.Map;

public class A74 {
	
		public static void main(String[] args) {
			
			HashMap<Integer,String> hmap=new HashMap<Integer,String>();
			hmap.put(1,"Hemant");
			hmap.put(2,"Kishor");
			hmap.put(3,"Sarth");
			hmap.put(4,"Rudra");
			hmap.put(5,"Kushal");
			hmap.put(6,"Vatshal");
			
			System.out.println("Collection view of  the value in HashMap : \n"+hmap.values());
			
			
			
		}
}
