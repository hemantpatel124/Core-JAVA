/* "Write a Java program that reads a positive integer and count the number of digits the number.
Input an integer number less than ten billion: 125463 
Number of digits in the number: 6"
 */

package assignment;

import java.util.Scanner;

public class A8 {
	
	public static void main(String[] args) {
		
		int num;
		int count=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter integer number : ");
		num=sc.nextInt();
		
		while(num>0) {
			num=num/10;
			count=count+1;
		}
		
		
		System.out.println("Total positive number : " + count);
		
	}
}
