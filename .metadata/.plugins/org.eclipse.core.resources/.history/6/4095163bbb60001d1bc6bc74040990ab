//Write a Java program to retrieve an element (at a specified index) from a given array list.

package assignment;

import java.util.Scanner;

public class A51 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of array : ");
		int size=sc.nextInt();
		
		int arr[]=new int[size];
		
		for(int i=0; i<arr.length;i++) {
			System.out.println("enter element a["+i+"]");
			arr[i]=sc.nextInt();
		}
		
		
		
		int num;
		int sn=0;
		System.out.println("\nenter number to search in array");
		num=sc.nextInt();
		int count=0;
		
		for(int i=0; i<arr.length;i++) {
			if(num == arr[i]) {
				count++;
				sn=arr[i];
				break;
			}
		}
		if(count == 1) {
			System.out.println("result : "+sn);
		}
		else {
			System.out.println("element not found!!!!");
		}
		
		
	}
}
