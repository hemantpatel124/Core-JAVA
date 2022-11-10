class A{
	//Parent class | Base class | Super class
	public void aMethod() {
		System.out.println("A class method");
	}
}
class B extends A{
	public void bMethod() {
		System.out.println("B class method");
	}
}
class C extends B{
	public void cMethod() {
		System.out.println("C class method");
	}
}

public class InheritanceDemo {
	public static void main(String[] args) {
		
		A a=new A();
		B b=new B();
		C c=new C();
		
		a.aMethod();
		
		b.aMethod();
		b.bMethod();
		
		c.aMethod();
		c.bMethod();
		c.cMethod();
		
	}
}
