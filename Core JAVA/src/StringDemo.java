
public class StringDemo {
	public static void main(String[] args) {
		
		String s1="Hemant";
		String s2="Patel";
		String s3="hemant";
		
		System.out.println("string s1:"+s1);
		System.out.println("string s1:"+s2);
		
		System.out.println("\nlength of string s1:"+s1.length());
		
		System.out.println("string s1 index of 2 character:"+s1.charAt(2));
		
		System.out.println("Concate s1 and s2:"+s1.concat(s2));
		
		System.out.println(s2.contains("tel"));
		
		System.out.println(s1.startsWith("H"));
		
		System.out.println(s1.endsWith("t"));
		
		System.out.println(s1.isEmpty());
		
		System.out.println(s1.replace('t', ' '));
		
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.toUpperCase());
		
		System.out.println(s1.trim());
		
		System.out.println(s1.compareTo(s3));
		
		System.out.println(s1.compareToIgnoreCase(s3));
		
		System.out.println(s1.equals(s3));
		
		System.out.println(s1.equalsIgnoreCase(s3));
	}
}
