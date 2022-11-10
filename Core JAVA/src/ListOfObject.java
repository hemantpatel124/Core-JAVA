import java.util.ArrayList;
import java.util.List;

class Students{
	int id;
	String name;
	double per;
	
	public Students(int id,String name,double per) {
		this.id = id;
		this.name=name;
		this.per= per;
	}
	
	@Override
	public String toString() {
		return "id : "+id+" name : "+name+" per : "+per;
	}
	
}


public class ListOfObject {

	public static void main(String[] args) {
		
		Students s1  = new Students(1, "Hemant", 56.5);
		Students s2  = new Students(2, "Sarth", 70.7);
		Students s3  = new Students(3, "Kishor", 85.4);
		Students s4  = new Students(4, "Akash", 80.00);
		
		
		List<Students> list = new ArrayList<Students>();
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		System.out.println(list);
	}
}
