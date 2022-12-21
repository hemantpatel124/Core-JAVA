import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

//class FileDemo{
//	int id;
//	String name;
//	int age;
//	public FileDemo(int id, String name,int age) {
//		this.id=id;
//		this.name=name;
//		this.age=age;
//	}
//}

public class PracticeDemo {

	public static void main(String[] args) throws IOException {
//		File file = new File("Hello1.txt"); 
//	       // creates the file 
//	       file.createNewFile(); 
//	       
//	      // FileDemo f=new FileDemo(1, "Hemant", 26);
//	       // creates a FileWriter Object 
//	       FileWriter writer = new FileWriter(file); 
//	       String s ="HEmant Patel";
//	       // Writes the content to the file 
//	       writer.write(s); 
//	       writer.flush(); 
//	       writer.close(); 
//	       
//	       //Creates a FileReader Object 
//	       FileReader fr = new FileReader(file); 
//	       char [] a = new char[50]; 
//	       fr.read(a); // reads the content to the array 
//	       for(char c : a) 
//	         System.out.print(c); //prints the characters one by one 
//	       fr.close(); 
		
		
//		//Hash Map
//		HashMap hmap=new HashMap<>();
//		hmap.put("One",new Integer(1));
//		hmap.put("Second",new Integer(2));
//		hmap.put("Three",new Integer(1));
//		hmap.put("One",new Integer(3));
//		System.out.println(hmap);
//		
//		
//		
//		//Hash Set
//		HashSet set=new HashSet();
//		set.add("One");
//		set.add("Second");
//		set.add("One");
//		System.out.println(set);
//		
//		//Hash Table
//		Hashtable ht=new Hashtable();
//		
//		ht.put("Hemant", 1);
//		ht.put("Rudra", 2);
//		ht.put("Hemant", 1);
//		System.out.println(ht);
//		
//		
//		
		
		
		
//			Scanner sc=new Scanner(System.in);
//			System.out.println("Enter three numbers");
//			int n1,n2,n3;
//			n1=sc.nextInt();
//			System.out.println("Enter size numbers");
//			n2=sc.nextInt();
//			n3=sc.nextInt();
//			
//			if(n1>n2 && n1>n3) {
//				System.out.println(n1+" 1st grettest number ");
//			}
//			else if(n2>n1 && n2>n3) {
//				System.out.println(n2+" 2nd grettest number ");
//			}
//			else {
//				System.out.println(n3+" 3rd grettest number");
//			}
		
	
//			System.out.println("\n===================================5+55+555===================================");
//
//			int num=n1,f=0,ans=0;
//			int s=n2;	
//			for(int i=1;i<=3;i++) {
//				f=f*10+num;
//				ans+=f;
//			}
//			System.out.println(""+ans);
	
			System.out.println("\n===================================Date Time===================================");
			Date d=new Date();
			System.out.println("Today date is :"+d);
	
			System.out.println("\n=================================== 1 to 100 divisible by 3 and 5================================");
			int count=0;
			for(int i=1; i<=100;i++) {
				
				if(i%3 == 0 || i%5==0) {
					System.out.println(i);
					count ++;
				}
				
			}
			System.out.println("Count : "+ count);
	
			System.out.println("\n===================================Char At===================================");
			String s="Topstechnlogy";
			StringBuffer sb=new StringBuffer(s);
			
			System.out.println("1st position  is T :"+s.charAt(0));
			System.out.println("10th position  is o :"+s.charAt(10));
			
			String s1="Hemant Patel";
			StringBuffer sb1=new StringBuffer(s1);
			
			System.out.println("Contacat string : "+sb.append(sb1));
			System.out.println("s : "+sb);
	
	
	}

}
