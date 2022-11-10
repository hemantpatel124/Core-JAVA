/*Create an abstract class 'Parent' with a method 'message'. 
  It has two subclasses each having a method with the same name 'message' 
  that prints "This is first subclass" and "This is second subclass" respectively. 
  Call the methods 'message' by creating an object for each subclass.
*/

package assignment;

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

public class A29 {
	public static void main(String[] args) {
		
		FirstClass f=new FirstClass();
		f.message();
		SecondClass s=new SecondClass();
		s.message();
	}
}
