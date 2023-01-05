package tDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import tDatabase.TDBConnection;
import tModel.Complain;
import tModel.Member;
import tModel.NoticeBoard;

public class MemberDAO {

		public static void insertMember(Member m) {
				
					try {
							
						Connection conn=TDBConnection.createConnection();
						String sql="insert into member_reg (name,email,contact,flno,prof,fmno,address,password,status) values(?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps=conn.prepareStatement(sql);
						
						ps.setString(1, m.getName());
						ps.setString(2, m.getEmail());
						ps.setLong(3, m.getContact());
						ps.setString(4, m.getFlno());
						ps.setString(5, m.getProf());
						ps.setInt(6,m.getFmno());
						ps.setString(7, m.getAddress());
						ps.setString(8, m.getPassword());
						ps.setString(9, m.getStatus());
						ps.executeUpdate();
						System.out.println("Data Inserted...");
					}
					catch (Exception e) {
							e.printStackTrace();
					}
		}
		
		

//		public static boolean checkStatus(String email) {
//				boolean status=false;
//			
//				try {
//						Connection conn=TDBConnection.createConnection();
//						String sql="select status from member_reg where email=?";
//						PreparedStatement ps=conn.prepareStatement(sql);
//						ps.setString(1, email);
//						ResultSet rs=ps.executeQuery();
//				
//						if(rs.next()) {
//							status=rs.getBoolean("status");
//						}
//			
//					} catch (Exception e) {
//							e.printStackTrace();
//					}
//		
//				return status;
//		}

		public static boolean checkEmail(String email) {
				boolean flag=false;
			
				try {
						Connection conn=TDBConnection.createConnection();
						String sql="select * from member_reg where email=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, email);
						ResultSet rs=ps.executeQuery();
					
						if(rs.next()) {
							flag=true;
						}
				
					} catch (Exception e) {
							e.printStackTrace();
				}
			
				return flag;
		}

		public static Member loginMember(Member m1) {
				Member m=null;
			
				try {
						Connection conn=TDBConnection.createConnection();
						String sql="select * from member_reg where email=? and password=? and status='Approved'";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, m1.getEmail());
						ps.setString(2, m1.getPassword());
						ResultSet rs=ps.executeQuery();
						
						if(rs.next()) {
							m =new Member();
							m.setM_id(rs.getInt("mid"));
							m.setName(rs.getString("name"));
							m.setEmail(rs.getString("email"));
							m.setContact(rs.getLong("contact"));
							m.setFlno(rs.getString("flno"));
							m.setProf(rs.getString("prof"));
							m.setFmno(rs.getInt("fmno"));
							m.setAddress(rs.getString("address"));
						}
						
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			return m;
		}
		public static List<NoticeBoard> noticeBoard() {

			ArrayList<NoticeBoard> notice_list = new ArrayList<NoticeBoard>();
			try {
				Connection conn = TDBConnection.createConnection();
				String sql = "select * from noticeboard";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					NoticeBoard n = new NoticeBoard();
					n.setSubject(rs.getString("subject"));
					n.setDate_time(rs.getString("date_time"));
					n.setDescription(rs.getString("description"));
					notice_list.add(n);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return notice_list;
		}
		
		
		
		
	
	
}
