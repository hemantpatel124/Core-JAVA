import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
interface RBI{
	public static void balanceinq() {
		System.out.println("In the Interface method..");
	}
}


class ConsDemo implements RBI{

	public void balanceinq() {
		System.out.println("Interface method");
		
	}
	
	
	
	
	int id;
	String name;
	int age;
////	public ConsDemo() {
////		System.out.println("Default cons...");
////	}
////	
////	public ConsDemo(int id, String name, int age) {
////		this.id=id;
////		this.name=name;
////		this.age=age;
////	}
////	
////	public ConsDemo(ConsDemo c) {
////		id=c.id;
////		name=c.name;
////		age=c.age;
////	}
//
//	
//	
//	@Override
//	public String toString() {
//		return "ConsDemo [id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
//
//
//
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
}
public class ConstructorDemo {
	
	public static void main(String[] args) throws IOException {
		ConsDemo d=new ConsDemo();
		//ConsDemo d1= new ConsDemo(1,"Hemant",25);
		//ConsDemo d2=new ConsDemo(d1);
		d.setId(1);
		d.setName("Hemant");
		d.setAge(25);
		
		
		
		System.out.println(d+":"+d.getName());
		//System.out.println(d2);
	
		ArrayList list=new ArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
	
		System.out.println("Array List: "+list);
		list.set(1, "Hemant");
		System.out.println("Array List: "+list);

		
		String name="Hemant Patel";
		FileOutputStream fout=new FileOutputStream("fileInOutStream.txt");
		byte[] b=name.getBytes();
		fout.write(b);
		fout.flush();
		fout.close();
		System.out.println("write doen...");
		
		
		FileInputStream fin=new FileInputStream("fileInOutStream.txt");
		int i;
		while((i=fin.read())!=-1) {
			System.out.print((char)i);
		}
		
		
		String name1="Hemant Patel";
		FileWriter fw=new FileWriter("file.txt");
		fw.write(name1);
		fw.flush();
		fw.close();
		System.out.println("write done using file Reader..");
		
		
		FileReader fr=new FileReader("file.txt");
		int i1;
		while((i1=fr.read())!=-1) {
			System.out.print((char)i1);
		}
		
		
		System.out.println("\n===================================HashMAP===================================");
		
		HashMap hmap=new HashMap();
		
		hmap.put(1, 101);
		hmap.put(2, 101);
		//hmap.put(2,102);
		hmap.put(null, 103);
		hmap.put(4, null);
		hmap.put(5, null);
		hmap.put(null,104);
		
		Set set=hmap.entrySet();
		Iterator itr=set.iterator();
		
//		while(itr.hasNext()) {
//			//Entry entry = (Entry)itr.next();
//			Entry entry=(Entry)itr.next();
//			
//			//System.out.println("key : "+entry.get());
//			//System.out.println("value : "+entry.getValue());
//		}
		
		System.out.println(hmap);
		
		System.out.println("\n===================================HashSet===================================");
		
		HashSet hs=new HashSet();
		hs.add(1);
		hs.add(1);
		hs.add(2);
		hs.add(3);
		
		
		Iterator itr1=hs.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		System.out.println(hs);
		
		System.out.println("\n===================================HashTable===================================");
	
		Hashtable  map=new Hashtable();
		map.put(1, "c");//entry
		map.put(2, "c++");
		map.put(3, "java");
		map.put("python",4);
		map.put(5, "c");
		//map.put(null, "xyz");
		
		System.out.println(map);

		System.out.println("\n===================================Interface===================================");
		RBI.balanceinq();
		d.balanceinq();
		
		System.out.println("\n===================================Array===================================");
		int arr[][]= {{1,2,3},{4,5,6},{7,8,9}};
		
		for(int r=0; r<arr.length;r++) {
			for(int c=0;c<arr.length;c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		
		
		System.out.println("Array length:"+arr.length);
		
		System.out.println("\n===================================TreeSet===================================");
		
		TreeSet ts=new TreeSet();
//		ts.add(1);
//		ts.add(4);
//		ts.add(3);
		//ts.add(2);
		ts.add("HEmant");
		ts.add("Rudra");
		ts.add("Kushal");
		ts.add("Vatsal");
		ts.add("@Hemant");
		ts.add("hemant");
		
		System.out.println(ts);
		
		System.out.println("\n===================================Vector===================================");
		
		
		Vector v=new Vector();
		v.add(1);
		v.add(2);
		v.add(3);
		
		System.out.println(v);

	}

}
