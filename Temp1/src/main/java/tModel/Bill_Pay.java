package tModel;

public class Bill_Pay {
	private int pbid,bid,amount;
	private String status, dop;
	public int getPbid() {
		return pbid;
	}
	public void setPbid(int pbid) {
		this.pbid = pbid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
	@Override
	public String toString() {
		return "Pay_Bill [pbid=" + pbid + ", bid=" + bid + ", amount=" + amount + ", status=" + status + ", dop=" + dop
				+ "]";
	}
	
	
	
}
