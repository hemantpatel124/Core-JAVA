class Student1{
	String name;
	public void setName(String s) {
		this.name=s;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return  name;
		

	}
	
}
public class EncapsulationDemo {
	
	public static void main(String[] args) {
		
		Student1 s= new Student1();
		s.setName("Hemant");
		System.out.println("Method : "+s.getName());
		
		System.out.println("Class print : "+s);
	}
}
