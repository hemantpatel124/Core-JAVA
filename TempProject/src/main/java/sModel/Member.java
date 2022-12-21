package sModel;

public class Member {
		
	private String name, email,flno,prof,address,password;
	private long contact;
	private int fmno,temp_id;
	private boolean status;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFlno() {
		return flno;
	}
	public void setFlno(String flno) {
		this.flno = flno;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public int getFmno() {
		return fmno;
	}
	public void setFmno(int fmno) {
		this.fmno = fmno;
	}
	public int getTemp_id() {
		return temp_id;
	}
	public void setTemp_id(int temp_id) {
		this.temp_id = temp_id;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", flno=" + flno + ", prof=" + prof + ", address="
				+ address + ", password=" + password + ", contact=" + contact + ", fmno=" + fmno + ", temp_id="
				+ temp_id + ", status=" + status + "]";
	}
	
	
	
	
}
