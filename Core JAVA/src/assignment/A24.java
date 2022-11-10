/*Create a class with a method that prints "This is a parent class" and its subclass with another method that prints "This is child class". 
  Now, create an object for each of the class and call 1 - method of parent class by object of parent 
  class 2 - method of child class by object of child class 3 - method of parent class by object of child class 
 */


package assignment;
class A{
	public void printA() {
		System.out.println("This is a parent class");
	}
}
class B extends A{
	public void printB() {
		System.out.println("This is child class");
	}
}
public class A24 {
	
	public static void main(String[] args) {
			
		A a=new A();
		B b=new B();
		
		a.printA();
		b.printB();
		b.printA();
	}
}
