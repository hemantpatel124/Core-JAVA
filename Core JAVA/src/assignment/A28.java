/*Print the sum, difference and product of two complex numbers by creating a class named 'Complex' with separate methods 
  for each operation whose real and imaginary parts are entered by user. 
 */

package assignment;

import java.util.Scanner;

class Complex{
	public Complex() {
	}
	int real, ima;
	
	Scanner sc=new Scanner(System.in);
	
	public Complex(int r, int i) {
		this.real=r;
		this.ima=i;
	}
	
	public void print() {
		System.out.println(real+" i"+ima);
	}
	public static Complex sum(Complex c1,Complex c2) {
		
		Complex temp=new Complex(0, 0);
		temp.real=c1.real+c2.real;
		temp.ima=c1.ima+c2.ima;

		return temp;
	}
	public void product() {
		System.out.println("Product is : "+real+" +i"+ima);
	}
	public void difference() {
		System.out.println("difference is : "+real+" +i"+ima);
	}
	
}

public class A28 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int real,ima;
		
		System.out.println("Enter first real and imaginary  number : ");
		real=sc.nextInt();
		ima=sc.nextInt();
		Complex c1=new Complex(real,ima);
		c1.print();
		
		System.out.println("Enter Seocnd real and imaginary  number : ");
		real=sc.nextInt();
		ima=sc.nextInt();
		Complex c2=new Complex(real,ima);
		c2.print();
		
		Complex temp=sum(c1, c2);
		temp.print();
		
		//Complex temp=sum(c1,c2);
		
		
	}

	private static Complex sum(Complex c1, Complex c2) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
