package tModel;

import java.util.Date;

public class NoticeBoard {
	private int nid;
	private String subject,description,date_time;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	@Override
	public String toString() {
		return "NoticeBoard [nid=" + nid + ", subject=" + subject + ", description=" + description + ", date_time="
				+ date_time + "]";
	}
		
}
