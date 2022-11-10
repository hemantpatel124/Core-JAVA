abstract class Parent{
	
	abstract void message();
}
class FirstClass extends Parent{
	
	void message() {
		System.out.println("This is first subclass");
	}

}

class SecondClass extends Parent{

	void message() {
		System.out.println("This is second subclass");
	}
	
}

public class AbstractDemo {
	public static void main(String[] args) {
		
		FirstClass f=new FirstClass();
		f.message();
		SecondClass s=new SecondClass();
		s.message();
	}
}
