import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size of array");
		int size=sc.nextInt();
		int a[]=new int[size];
		for(int i=0;i<a.length;i++) {
			System.out.println("enter element of a["+i+"] : ");
			a[i]=sc.nextInt();
		}
		
		int num;
		System.out.println("enter number to search in array");
		num=sc.nextInt();
		int count=0;
		
		for(int i=0; i<a.length;i++) {
			if(num == a[i]) {
				count++;
				break;
			}
		}
		if(count == 1) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
	}
}
