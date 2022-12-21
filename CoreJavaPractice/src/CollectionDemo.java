import java.util.*;

public class CollectionDemo {
	public static void main(String[] args) {
			ArrayList<String> list =new ArrayList();
			list.add("Hemant");
			list.add("Patel");
			
			
			for(String li:list) {
				System.out.println(li + li.length());
			}
			
			Iterator itr=list.iterator();
			
			while(itr.hasNext()) {
				System.out.println("Iterotor"+itr.next());
			}
			
			ListIterator ltr=list.listIterator(list.size());
			while(ltr.hasPrevious()) {
				System.out.println("Iterotor"+ltr.previous());
			}
	}
}
