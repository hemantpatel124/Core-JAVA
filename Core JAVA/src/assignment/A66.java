//Write a Java program to join two array lists.

package assignment;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class A66 {
		
		public static void main(String[] args) {
				
			List<String> list1 = new ArrayList<String>();
			list1.add("Hemant");
			list1.add("Kishor");
			list1.add("Rudra");
			list1.add("Kushal");
			list1.add("Vatshal");
			
			List<String> list2 = new ArrayList<String>();
			list2.add("H");
			list2.add("K");
			list2.add("R");
			list2.add("K");
			list2.add("V");
			
			System.out.println("List1 : "+list1);
			System.out.println("List2 : "+list2);
			
			ArrayList<String> list3=new ArrayList<String>();
			list3.addAll(list1);
			list3.addAll(list2);
			
			System.out.println("Join Two array list : ");
			System.out.println(list3);
			
		}
}
