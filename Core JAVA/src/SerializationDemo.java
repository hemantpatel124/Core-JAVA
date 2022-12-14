import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	int id;
	String name;
	double salary;
	
	public Employee(int id,String name, double salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	@Override
	public String toString() {

		return "Employee :      id: "+id+", name : "+name+", salary : "+salary+""; 
	}
}

public class SerializationDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee emp1=new Employee(1, "Hemant", 1000);
		Employee emp2=new Employee(2, "Sarth", 2000);
		
		FileOutputStream fout=new FileOutputStream("serialization.txt");
		ObjectOutputStream os=new ObjectOutputStream(fout);
		os.writeObject(emp1);
		os.writeObject(emp2);
		os.flush();
		os.close();
		System.out.println("Object written successfully");
		
		FileInputStream fin= new FileInputStream("serialization.txt");
		ObjectInputStream ois=new ObjectInputStream(fin);
		
		Employee e1=(Employee)ois.readObject();
		System.out.println(e1);
		Employee e2=(Employee)ois.readObject();
		System.out.println(e2);
		
		
	}
}
