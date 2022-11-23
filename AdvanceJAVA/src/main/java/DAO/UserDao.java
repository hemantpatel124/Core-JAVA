package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.User;

public class UserDao {
	
		public static void insertUser(User u) {
			
			try {
					Connection conn=DBConnection.createConnection();
					String sql="insert into student (name, contact, address, email,password) values(?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					
					ps.setString(1, u.getName());
					ps.setLong(2, u.getContact());
					ps.setString(3, u.getAddress());
					ps.setString(4, u.getEmail());
					ps.setString(5, u.getPassword());
					ps.executeUpdate();
					System.out.println("Data inserted");
			} catch (Exception e) {
					e.printStackTrace();
			}
		}
		
		public static boolean checkEmail(String email) {
				boolean flag=false;
				
				try {
						Connection conn=DBConnection.createConnection();
						String sql="select * from student where email=?";
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

		public static User loginUser(User u) {
				User u1=null;
				
				try {
							Connection conn=DBConnection.createConnection();
							String sql="select * from student where email=? and password=?";
							PreparedStatement ps=conn.prepareStatement(sql);
							ps.setString(1, u.getEmail());
							ps.setString(2, u.getPassword());
							ResultSet rs=ps.executeQuery();
							
							if(rs.next()) {
								u1 =new User();
								u1.setId(rs.getInt("id"));
								u1.setName(rs.getString("name"));
								u1.setContact(rs.getLong("contact"));
								u1.setAddress(rs.getString("address"));
								u1.setEmail(rs.getString("email"));
								u1.setPassword(rs.getString("password"));
							}
							
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				return u1;
		}

		public static List<User> getAllStudents() {
			ArrayList<User> list= new ArrayList<User>();
			
			try {
					Connection conn=DBConnection.createConnection();
					String sql="select * from student";
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
				
					while(rs.next()) {
						User u2 =new User();
						u2.setId(rs.getInt("id"));
						u2.setName(rs.getString("name"));
						u2.setContact(rs.getLong("contact"));
						u2.setAddress(rs.getString("address"));
						u2.setEmail(rs.getString("email"));
						u2.setPassword(rs.getString("password"));
						list.add(u2);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			return list;
		}
		
		
		public static User getDataById(int id) {
			User u1=null;
			try {
					Connection conn=DBConnection.createConnection();
					String sql="select * from student where id=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					
					ps.setInt(1,id);
					ResultSet rs=ps.executeQuery();
				
					if(rs.next()) {
						u1 =new User();
						u1.setId(rs.getInt("id"));
						u1.setName(rs.getString("name"));
						u1.setContact(rs.getLong("contact"));
						u1.setAddress(rs.getString("address"));
						u1.setEmail(rs.getString("email"));
						u1.setPassword(rs.getString("password"));
					}
				
				} catch (Exception e1) {
						e1.printStackTrace();
				}
					return u1;
			}
		
		
		public static void updateUser(User u) {
				try {
						Connection conn=DBConnection.createConnection();
						String sql="update student set name=?, contact=?, address=?, email=?, password=? where id=?";
						PreparedStatement ps=conn.prepareStatement(sql);
					
						ps.setString(1, u.getName());
						ps.setLong(2, u.getContact());
						ps.setString(3, u.getAddress());
						ps.setString(4, u.getEmail());
						ps.setString(5, u.getPassword());
						ps.setInt(6, u.getId());
						ps.executeUpdate();
						System.out.println("Data updated...");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		
		public static void deleteUser(int id) {
				try {
						Connection conn=DBConnection.createConnection();
						String sql="delete from student where id=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
						System.out.println("data deleted..");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}
		
		
}
