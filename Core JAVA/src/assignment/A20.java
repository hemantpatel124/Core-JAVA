/*W.A.J.P to find the second most frequent character in a given string. 
 The given string is: successes The second most frequent char in the string is: c
 */
package assignment;

import java.util.HashMap;

public class A20 {
	public static void main(String[] args) {
		
		String s="successes";
		
		HashMap<Character, Integer> hm=new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			
			char ch	=s.charAt(i);
			
			if(hm.containsKey(ch)){
				int old=hm.get(ch);
				int new1=old+1;
				hm.put(ch, new1);
			}
			else {
				hm.put(ch,1);
			}
		}
		
		
	}
}
