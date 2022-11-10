import java.util.InputMismatchException;
import java.util.Scanner;

class ThrowsThrow{
	
	public void divided() throws ArithmeticException, InputMismatchException{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter a = ");
		int a=sc.nextInt();
	
		System.out.println("enter b = ");
		int b=sc.nextInt();
		
		int c=a/b;
		System.out.println(c);

	}
}

public class ExceptionDemo {
	
	public static void main(String[] args) {
		try {
			ThrowsThrow t=new ThrowsThrow();
			t.divided();
		}catch(ArithmeticException e){
			System.out.println("cannot divided by zero");
		}
		
		
		
//		try {
//				Scanner sc=new Scanner(System.in);
//				
//				System.out.println("enter a = ");
//				int a=sc.nextInt();
//				
//				System.out.println("enter b = ");
//				int b=sc.nextInt();
//				
//				int c=a/b;
//				System.out.println(c);
//			
//		} catch (ArithmeticException e) {
//			System.out.println("number cannot divided by zero");
//		}
//		catch (InputMismatchException e) {
//			System.out.println("number cannot divide by string");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("this will execute everytime");
//		}
		
	}
}
	