package tDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import tDatabase.TDBConnection;
import tModel.*;

public class AdminDAO {
	public static List<Member> getMemberPendingList() {

		ArrayList<Member> member_list = new ArrayList<Member>();
		try {
			Connection conn = TDBConnection.createConnection();
			String sql = "select * from member_reg where status='Pending'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();
				m.setM_id(rs.getInt("mid"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setContact(rs.getLong("contact"));
				m.setFlno(rs.getString("flno"));
				m.setProf(rs.getString("prof"));
				m.setFmno(rs.getInt("fmno"));
				m.setAddress(rs.getString("address"));
				m.setStatus(rs.getString("status"));
				member_list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member_list;
	}
	
	public static void approvedMember(int mid) {

		try {
			Connection conn = TDBConnection.createConnection();
			String sql = "update member_reg set status='Approved' where mid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			ps.executeUpdate();
			System.out.println("Member Approved");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static List<Member> getAllMemberdetails() {

		ArrayList<Member> member_list = new ArrayList<Member>();
		try {
			Connection conn = TDBConnection.createConnection();
			String sql = "select * from member_reg";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();
				m.setM_id(rs.getInt("mid"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setContact(rs.getLong("contact"));
				m.setFlno(rs.getString("flno"));
				m.setProf(rs.getString("prof"));
				m.setFmno(rs.getInt("fmno"));
				m.setAddress(rs.getString("address"));
				m.setStatus(rs.getString("status"));
				member_list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member_list;
	}
	
	public static boolean loginAdmin(String email, String passsword) {
		boolean falg=false;
		try {
				Connection conn=TDBConnection.createConnection();
				String sql="select * from admin where email=? and password=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, passsword);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					falg=true;
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		return falg ;
	}
	public static void noticeGenerat(String date_time,String sub, String des) {
			try {
					Connection conn=TDBConnection.createConnection();
					String sql="insert into noticeboard (date_time,subject, description) values(?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					//ps.setLong(1, date_time);
					ps.setString(1,date_time);
					ps.setString(2, sub);
					ps.setString(3,des );
					ps.executeUpdate();
					System.out.println("Notice Generated");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	public static List<NoticeBoard> noticeList() {

		ArrayList<NoticeBoard> notice_list = new ArrayList<NoticeBoard>();
		try {
			Connection conn = TDBConnection.createConnection();
			String sql = "select * from noticeboard";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				NoticeBoard n = new NoticeBoard();
				n.setNid(rs.getInt("nid"));
				n.setDate_time(rs.getString("date_time"));
				n.setSubject(rs.getString("subject"));
				notice_list.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return notice_list;
	}
	public static String getLocalDateTime() {
		String dateTime=null;
		try {
			LocalDateTime now = LocalDateTime.now();
			System.out.println("Timing : "+now);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");  
			 dateTime = now.format(format);  
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return dateTime;
	}
	
	

}
