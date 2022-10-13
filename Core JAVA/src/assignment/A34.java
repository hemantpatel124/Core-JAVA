/*"Write a program which will ask the user to enter his/her marks (out of 100). 
Define a method that will display grades according to the marks entered as below:
Marks Grade
1-100	 A
1-90	 B
1-80	 B
1-70	 C
1-60	 D
41-50  	DD
40        Fail"
 */

package assignment;

import java.util.Scanner;

public class A34 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter marks :");
		int m=sc.nextInt();
		
		if (m < 40) {
			System.out.println("fail");
		} 
		else if (m >= 41 && m <= 50) {
			System.out.println("DD greade");
		} 
		else if (m >= 51 && m <= 60) {
			System.out.println("D grade");
		} 
		else if (m >= 61 && m <= 70) {
			System.out.println("C grade");
		} 
		else if (m >= 71 && m <= 80) {
			System.out.println("B grade");
		} 
		else if (m >= 81 && m <= 90) {
			System.out.println("A grade");
		}
		else if (m >= 91 && m <= 100) {
			System.out.println("A+ grade");
		}
		else {
			System.out.println("invalid input");
		}
	}
}
