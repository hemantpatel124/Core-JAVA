/*"W.A.J.P to create the validate method that takes integer value as a parameter. 
	If the age is less than 18, then throw an Arithmetic Exception otherwise print a message welcome to vote.
	O/P- Enter your age: 16
	Exception in thread main java. Lang. Arithmetic Exception: not valid"
 */
package assignment;

import java.util.Scanner;

class AgeException extends Exception{
	public AgeException(String s) {
		System.out.println(s);
	}
}


public class A40 {
		
		public static void main(String[] args){
				
				Scanner sc=new Scanner(System.in);
				int age;
				System.out.println("please enter your age : ");
				age=sc.nextInt();
				
				
				try {
					
					if(age<18) {
						throw new AgeException("not valid age for vote");
					}
					else {
						System.out.println("Welcome to vote");
					}
					
				}
				catch (AgeException e) {
					System.out.println(e);
				}
				
				
		}
		
		
		
		
		
}
