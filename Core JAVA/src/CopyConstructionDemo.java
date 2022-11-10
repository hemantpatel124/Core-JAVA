class Student {
	int id;
	String name;
	Student(int i,String n){
		id=i;
		name=n;
	}
	
	public Student(Student s) {
		id=s.id;
		name=s.name;
	}
	public void display() {
		System.out.println(id+" "+name);
	}
}

public class CopyConstructionDemo {
	public static void main(String[] args) {
		Student s1=new Student(1, "Hemant");
		Student s2=new Student(s1);
		
		s1.display();
		s2.display();
	}
}
