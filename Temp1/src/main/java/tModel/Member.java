package tModel;

public class Member {
	
	private String name, email,flno,prof,address,password,status;
	private long contact;
	private int m_id,fmno;
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
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getFmno() {
		return fmno;
	}
	public void setFmno(int fmno) {
		this.fmno = fmno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", flno=" + flno + ", prof=" + prof + ", address="
				+ address + ", password=" + password + ", status=" + status + ", contact=" + contact + ", m_id=" + m_id
				+ ", fmno=" + fmno + "]";
	}
	
	
	
	
}
