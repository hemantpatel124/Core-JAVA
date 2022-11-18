//Write a Java program to associate the specified value with the specified key in a Hash Map.

package assignment;

import java.util.HashMap;
import java.util.Map;

public class A60 {
	
		public static void main(String[] args) {
				

			HashMap<Integer,String> hmap=new HashMap<Integer,String>();
			hmap.put(1,"Hemant");
			hmap.put(2,"Kishor");
			hmap.put(3,"Sarth");
			hmap.put(4,"Rudra");
			hmap.put(5,"Kushal");
			hmap.put(6,"Vatshal");
			
			System.out.println("HashMap : "+hmap);
			
			for(Map.Entry h:hmap.entrySet()) {
				System.out.println(h.getKey()+ " "+h.getValue());
			}
			
			
		}
}
