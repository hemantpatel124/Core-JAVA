import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;

class Demo implements Serializable{
	int id;
	String name;
	
	public Demo(int id, String name) {
		this.id=id;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Employee  [id=" + id + ", name=" + name + "]";
	}
	
	
}
public class SerializationDemo {
		public static void main(String[] args) throws FileNotFoundException,IOException,ClassNotFoundException {
			Demo d1=new Demo(1,"Hemant");
			Demo d2=new Demo(2,"Rudra");
			Demo d3=new Demo(3,"Vatsal");
			Demo d4=new Demo(4,"Kushal");
		
			ArrayList<Demo> list=new ArrayList<Demo>();
			list.add(d1);
			list.add(d2);
			list.add(d3);
			list.add(d4);
			list.add(d1);
			list.add(d2);
			list.add(d3);
			list.add(d4);
			
			FileOutputStream fout=new FileOutputStream("newFile.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fout);
			oos.writeObject(list);
//			oos.writeObject(d2);
//			oos.writeObject(d3);
//			oos.writeObject(d4);
			oos.flush();
			oos.close();
			System.out.println("All file written successfully...");
			
			FileInputStream fis=new FileInputStream("newFile.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			ArrayList<Demo> readlist=new ArrayList<Demo>();
			readlist=(ArrayList<Demo>) ois.readObject();
			
			System.out.println(readlist);
			
			
//			Demo readData=(Demo)ois.readObject();
//			System.out.println(readData);
//			Demo readData1=(Demo)ois.readObject();
//			System.out.println(readData1);
//			Demo readData2=(Demo)ois.readObject();
//			System.out.println(readData2);

		}
}
