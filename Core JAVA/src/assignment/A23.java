/* Create a class to print the area of a square and a rectangle. 
   The class has two methods with the same name but different number of parameters. 
   The method for printing area of a rectangle has two parameters which are length and breadth respectively while 
   the other method for printing area of square has one parameter which is side of square.
 */

package assignment;

class PrintArea {
	
	public void print(int length) {
		
		System.out.println("Area of Square is : "+(length*length));
	}
	
	public void print(int length, int breadth) {
		System.out.println("Area of Rectangle is : "+ (length*breadth));
	}
	
}

public class A23 {
	
	public static void main(String[] args) {
		
		PrintArea p=new PrintArea();
		p.print(5);
		p.print(4,5);
	}
}
