/*"W.A.J.P to find all interleaving of given strings. 
The given strings are: WX YZ
The interleaving strings are: YWZX WYZX YWXZ WXYZ YZWX WYXZ"
 */

package assignment;

import java.util.HashSet;
import java.util.*;

public class A19 {
	
	public static void allInterleavings(String res, String P, String Q, Set < String > out) {
		
		  if (P.length() == 0 && Q.length() == 0) {
		   out.add(res);
		   return;
		  }
		  if (P.length() > 0) {
			  allInterleavings(res, P, Q, out);
		  }
		  if (Q.length() > 0) {
		   allInterleavings(res, P, Q, out);
		  }
	}
	
	public static void main(String[] args) {
	
		String s1="WX";
		String s2="YZ";
		
		System.out.println("The given string is :"+s1+" "+s2);
		
		System.out.println("\nThe interleaving strings are: ");
		
		Set<String> s3 =new HashSet();
		allInterleavings("", s1, s2, s3);
		
		s3.stream().forEach(System.out::println);
	}
}
