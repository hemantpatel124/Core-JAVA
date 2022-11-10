import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
	public static void main(String[] args) {
		
		Set set = new HashSet();
		set.add(1);
		set.add("name");
		set.add(45.4);
		set.add(true);
		set.add('l');
		set.add(9878);
		set.add(1);
		
		System.out.println(set);
		
		Iterator itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
}
