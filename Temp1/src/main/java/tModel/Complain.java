package tModel;

public class Complain {
	private int cid,mid;
	private String doc,subject,complain,status,replay,dor;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getReplay() {
		return replay;
	}
	public void setReplay(String replay) {
		this.replay = replay;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complain [cid=" + cid + ", mid=" + mid + ", doc=" + doc + ", subject=" + subject + ", complain="
				+ complain + ", status=" + status + ", replay=" + replay + ", dor=" + dor + "]";
	}
	
	
	
}
