class Account{
	int acno;
	String name;
	static String bname="SBI";
	
	Account(int i, String s){
		acno=i;
		name=s;
	}
	
	public void display() {
		System.out.println("Account number : "+acno+"  Holder name : "+name+"  Bank name: "+bname);
	}
	
	static void changeBank() {
		bname="HDFC";
	}
}
public class StaticDemo {

	public static void main(String[] args) {
		Account a1=new Account(101,"Hemant");
		Account a2=new Account(102, "Nitya");
			
		a1.display();
		Account.changeBank();
		a2.display();
	}
	
	static {
		System.out.println(" Welcome to Your Bank Account ");
	}
}
