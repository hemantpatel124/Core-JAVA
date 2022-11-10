class Addition{
	
	public void add(int a, int b) {
		System.out.println("Add method with two integer parameter : "+(a+b));
	}
	public void add(int a, int b, int c) {
		System.out.println("Add method with three integer parameter : "+(a+b+c));
	}
	public void add(float a, float b) {
		System.out.println("Add method with two float parameter : "+(a+b));
	}
	public void add(double a, double b) {
		System.out.println("Add method with two double parameter : "+(a+b));
	}
	public void add(int a, double b) {
		System.out.println("Add method with intger and double parameter : "+(a+b));
	}
}

public class OverloadingDemo {
	
	public static void main(String[] args) {
		
		Addition a=new Addition();
		
		a.add(5, 10);
		a.add(4,5,6);
		a.add(5.5f, 5.5f);
		a.add(7.5, 4.5);
		a.add(7, 5.5);
	}
}
