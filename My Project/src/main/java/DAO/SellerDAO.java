package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.mysql.cj.xdevapi.Session;

import DBConnection.*;
import Model.*;
public class SellerDAO {
	
	public static void insertSeller(User u) {
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="insert into seller_register (name, contact, address, email,password) values(?,?,?,?,?)";
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
				String sql="select * from seller_register where email=?";
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
	
	public static User loginSeller(User u) {
		User u1=null;
		
		try {
					Connection conn=DBConnection.createConnection();
					String sql="select * from seller_register where email=? and password=?";
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
	
	public static boolean checkPassword(String password) {
		boolean flag=false;
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select * from seller_register where password=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, password);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					flag=true;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static void changePassword(User u) {
			try {
					Connection conn=DBConnection.createConnection();
					String sql="update seller_register set  password=? where email=?";
					PreparedStatement ps=conn.prepareStatement(sql);
		
					ps.setString(1, u.getPassword());
					ps.setString(2, u.getEmail());
					ps.executeUpdate();
					System.out.println("Data updated...");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static User getSellerDataById(int id) {
				User u1=null;
					try {
							Connection conn=DBConnection.createConnection();
							String sql="select * from seller_register where id=?";
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
							}
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				return u1;
		}
		
		public static void updateSellerProfile(User u) {
				try {
						Connection conn=DBConnection.createConnection();
						String sql="update seller_register set name=?, contact=?, address=?, email=? where id=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						
						ps.setString(1, u.getName());
						ps.setLong(2, u.getContact());
						ps.setString(3, u.getAddress());
						ps.setString(4, u.getEmail());
						ps.setInt(5, u.getId());
						
						ps.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
		}


}
