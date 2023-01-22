package cModel;

import java.util.Date;

public class Student {
	private int sid,dcode;
	private long scontact;
	private String sname,semail,scity,spassword,sphoto,sgender;
	private Date sdob;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public long getScontact() {
		return scontact;
	}
	public void setScontact(long scontact) {
		this.scontact = scontact;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
	public String getSphoto() {
		return sphoto;
	}
	public void setSphoto(String sphoto) {
		this.sphoto = sphoto;
	}
	
	
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public Date getSdob() {
		return sdob;
	}
	public void setSdob(Date sdob) {
		this.sdob = sdob;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", dcode=" + dcode + ", scontact=" + scontact + ", sname=" + sname + ", semail="
				+ semail + ", scity=" + scity + ", spassword=" + spassword + ", sphoto=" + sphoto + ", sgender="
				+ sgender + ", sdob=" + sdob + "]";
	}

	
	
	
}
