import java.util.Scanner;

public class Loops {
	public static void main(String[] args) {
		//for loop
		Scanner sc= new Scanner(System.in);
		//int start=sc.nextInt();
		System.out.println("enter end valu:");
		int end=sc.nextInt();
		
		
		System.out.println("\nFor Loop");
		for(int i=1;i<=end; i++) {
			System.out.println(i+". Hemant");
		}
		
		
		//while loop

		System.out.println("\nwhile Loop");
		int j=1;
		while(j<=end){
			System.out.println(j+". Hemant");
			j++;
		}
		
		
		
		//do while loop
		System.out.println("\ndo while Loop");
		int k=1;
		do {
			System.out.println(k+". Hemant");
			k++;
		}
		while(k<=end);
	}
}
