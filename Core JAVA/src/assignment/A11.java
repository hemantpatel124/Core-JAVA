/* "Write a Java program that accepts an integer (n) and computes the value  of n+nn+nnn. 
Input number: 5
5 + 55 + 555"
 */
package assignment;

import java.util.Scanner;

public class A11 {
	
	public static void main(String[] args) {
		
		long num,f=0,ans=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number : ");
		num=sc.nextLong();
		
		for(int i=1;i<=3;i++) {
			f=f*10+num;
			ans+=f;
		}
		System.out.println("Compute value : "+ans);
	}
}
