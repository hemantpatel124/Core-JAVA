import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Mobile implements Comparable<Mobile>{
	
	int price;
	int ram;
	String name;
	
	public Mobile(int price, int ram, String name) {
		this.price=price;
		this.ram=ram;
		this.name=name;
	}
	
	public int getPrice() {
		return price;
	}
	public int getRam() {
		return ram;
	}
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Mobile o) {
		if(this.getRam()>o.getRam()) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
	@Override
	public String toString() {
		
		return "price : "+price+" ram : "+ram+" name : "+name;
	}
	
}
public class ComparableDemo {
	
	public static void main(String[] args) {
		
		Mobile m1 = new Mobile(10000, 4, "MI");
		Mobile m2 = new Mobile(30000, 6, "Apple");
		Mobile m3 = new Mobile(20000, 2, "Samsung");
		Mobile m4 = new Mobile(20000, 8, "Oppo");
		Mobile m5 = new Mobile(20000, 6, "Vivo");
		
		List<Mobile> list=new ArrayList<Mobile>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		
		Collections.sort(list);
		for(Mobile m:list) {
			System.out.println(m);
		}
	}
}
