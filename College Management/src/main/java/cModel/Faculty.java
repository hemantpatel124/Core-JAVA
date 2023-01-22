package cModel;

public class Faculty {
	private int fid,dcode;
	private long fcontact;
	private String fname,femail,fcity,fpassword;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public long getFcontact() {
		return fcontact;
	}
	public void setFcontact(long fcontact) {
		this.fcontact = fcontact;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFcity() {
		return fcity;
	}
	public void setFcity(String fcity) {
		this.fcity = fcity;
	}
	public String getFpassword() {
		return fpassword;
	}
	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", dcode=" + dcode + ", fcontact=" + fcontact + ", fname=" + fname + ", femail="
				+ femail + ", fcity=" + fcity + ", fpassword=" + fpassword + "]";
	}
	
	
	
}
