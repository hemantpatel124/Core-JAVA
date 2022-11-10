/*Create a class to print an integer and a character with two methods having the same name but different sequence of the integer and the character parameters.
Create a class to print an integer and a character with two methods having the same name but different sequence of the integer and the character parameters.
For example, if the parameters of the first method are of the form (int n, char c), then that of the second method will be of the form (char c, int n).f
*/

package assignment;

import java.util.Scanner;

class Print1{
	Scanner sc=new Scanner(System.in);
	
	public void print(int a, char c) {
		
		System.out.println("First Method     intger :"+a+" character : "+c);
	}
	public void print(char c, int i) {
		System.out.println("Second Method    character :"+c+" intger : "+i);
	}
	
}

public class A22 {

	public static void main(String[] args) {
		Print1 p=new Print1();
		p.print(5,'d');
		p.print('h', 1);
	}
	
}