import java.util.*;
import java.util.Map.Entry;

public class HashMapDemo {
	
	public static void main(String[] args) {
		
		Map  map=new HashMap();
		map.put(1, "c");//entry
		map.put(2, "c++");
		map.put(3, "java");
		map.put("python",4);
		map.put(5, "c");
		map.put(null, "xyz");
		
		System.out.println(map);
		
		Set set=map.entrySet();
		Iterator itr=set.iterator();
		
		while(itr.hasNext()) {
			Entry entry = (Entry)itr.next();
			System.out.println("key : "+entry.getKey());
			System.out.println("value : "+entry.getValue());
		}
		
	}
}
