package sDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sModel.Member;
import sdatabaseConnection.SDBConnection;

public class MemberDAO {
		
			public static void insertMember(Member m) {
				
					try {
							Connection conn=SDBConnection.createConnection();
							String sql="insert into member_reg (name,email,contact,flno,prof,fmno,address,password) values(?,?,?,?,?,?,?,?)";
							PreparedStatement ps=conn.prepareStatement(sql);
							
							ps.setString(1, m.getName());
							ps.setString(2, m.getEmail());
							ps.setLong(3, m.getContact());
							ps.setString(4, m.getFlno());
							ps.setString(5, m.getProf());
							ps.setInt(6,m.getFmno());
							ps.setString(7, m.getAddress());
							ps.setString(8, m.getPassword());
							ps.executeUpdate();
							System.out.println("Data Inserted...");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			
			public static boolean checkEmail(String email) {
					boolean flag=false;
				
					try {
							Connection conn=SDBConnection.createConnection();
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
			public static boolean checkStatus(String email) {
				boolean flag=false;
			
				try {
						Connection conn=SDBConnection.createConnection();
						String sql="select status from member_reg where email=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, email);
						ResultSet rs=ps.executeQuery();
					
						if(rs.next()) {
							flag=rs.getBoolean("status");
						}
				
					} catch (Exception e) {
						e.printStackTrace();
				}
			
				return flag;
			}
			
			public static Member loginMember(Member m) {
	 			Member m1=null;
				
				try {
							Connection conn=SDBConnection.createConnection();
							String sql="select * from member_reg where email=? and password=?";
							PreparedStatement ps=conn.prepareStatement(sql);
							ps.setString(1, m.getEmail());
							ps.setString(2, m.getPassword());
							ResultSet rs=ps.executeQuery();
							
							if(rs.next()) {
								m1=new Member();
								
								m1.setTemp_id(rs.getInt("mid"));
								m1.setName(rs.getString("name"));
								m1.setEmail(rs.getString("email"));
								m1.setContact(rs.getLong("contact"));
								m1.setFlno(rs.getString("flno"));
								m1.setProf(rs.getString("prof"));
								m1.setFmno(rs.getInt("fmno"));
								m1.setAddress(rs.getString("address"));
								m1.setStatus(rs.getBoolean("status"));
							}
							
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				return m1;
			}
			
			
			
}
