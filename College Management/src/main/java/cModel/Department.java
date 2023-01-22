package cModel;

public class Department {
	private int dcode;
	private String dname;
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Department [dcode=" + dcode + ", dname=" + dname + "]";
	}
	
	
	
	
	
}
