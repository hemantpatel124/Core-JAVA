import java.util.Scanner;

public class UserInput {
	
	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter value of num1 and num2");
		
		num1=sc.nextInt();
		num2=sc.nextInt();
		
		System.out.println("Sum is two numbwr = "+(num1+num2));
	}

}
