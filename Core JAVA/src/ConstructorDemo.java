class Demo{
		int a,b;
		Demo(){
			System.out.println("Default constructor");
		}
		Demo(int a, int b){
			this.a=a;
			this.b=b;
			System.out.println("para constructor");
		}
		Demo(String s){
			System.out.println(	"string para constructor");
		}
		public void sum() {
			System.out.println("Sum of i and j : "+(a+b));
		}
}
class Demo1{
	int i,j;
	Demo1(Demo d){
		this.i=d.a;
		this.j=d.b;
		System.out.println("para constructor");
	}
	public void sum1() {
		System.out.println("Demo1 method Sum1 of i and j : "+(i+j));
	}
}
public class ConstructorDemo {
	public static void main(String[] args) {
		
		Demo d=new Demo(10,20);
		d.sum();
		Demo1 d1=new Demo1(d);
		d1.sum1();
	}
}
