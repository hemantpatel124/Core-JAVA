import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add(1);
		list.add("name");
		list.add(27.7);
		list.add('h');
		list.add(false);
		list.add(12323);
		list.add("xyz");
		list.add(1);
		
		list.remove(2);
		
		System.out.println(list);
		System.out.println("size of list : "+list.size());
		
		Iterator itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
