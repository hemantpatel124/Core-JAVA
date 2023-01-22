package Model;

public class Cart {
	private int cid, pid, cusid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", cusid=" + cusid + "]";
	}

}