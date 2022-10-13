//Write a Java program to print the ASCII value of a given character.

package assignment;

import java.util.Scanner;

public class A10 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter single character : ");
		
		char c =sc.next().charAt(0);
		int ch= c;
		
		System.out.println("Given character "+c+" ASCII value is : "+ch);
		
	}
}
