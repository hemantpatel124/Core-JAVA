/*"W.A.J. P to demonstrate try catch block, take two numbers from the user 
   by Command line argument and perform the division operation and handle Arithmetic 
O/P-
Exception in thread main java. Lang. Arithmetic Exception:/ by zero" 
 */
package assignment;


public class A39 {
	
	public static void main(String[] args) throws Exception {
		
		int num1;
		int num2;
		int result;
		
		try {
				num1=Integer.parseInt(args[0]);
				num2=Integer.parseInt(args[1]);
			result=num1/num2;
			System.out.println("Division result is : "+result);
		}
		catch (ArithmeticException e) {
			System.out.println("Zero can not divided by any number");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
}

