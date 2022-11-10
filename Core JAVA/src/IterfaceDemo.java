interface RBI{
	public void balanceDisplay();
}
interface SBI extends RBI{
	public void intrestRate();
}
interface BOB extends RBI{
	public void homloan();
}
class BankAccount implements SBI,BOB{

	
	public void balanceDisplay() {
		System.out.println("This is RBI method");
	}

	@Override
	public void intrestRate() {
		System.out.println("This is SBI method");
	}

	@Override
	public void homloan() {
		System.out.println("This is BOB method");
	}
	
}


public class IterfaceDemo {
	
	public static void main(String[] args) {
			
		BankAccount b=new BankAccount();
		b.balanceDisplay();
		b.intrestRate();
		b.homloan();
		
	}
}
