import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		//System.out.println("Hello Hemant Your first Program ");
	
		 String[] menu = {"Tea", "Espresso", "Americano", "Water", "Hot Chocolate"};
	        Scanner sc = new Scanner(System.in);
	        //your code goes here
	        int choice;
	        System.out.println("Enter your choice : ");
	        choice=sc.nextInt();
	        if(choice==menu.length){
	            System.out.println(menu[choice]);
	        }
	        else{
	            System.out.println("Invalid");
	        }
	
	}
	
}
