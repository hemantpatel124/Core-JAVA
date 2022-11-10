class A1{
	public void display() {
		System.out.println("This is A1 Class method");
	}
}
class B1 extends A1{
	
	public void display() {
		System.out.println("This is B1 Class method");
	}
	
}
public class OverridingDemo {
	
	public static void main(String[] args) {
		
		B1 b=new B1();
		b.display();
		
	}
}
