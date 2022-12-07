package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.DBConnection;
import Model.Coustomer;


public class CoustomerDAO {
				

	public static void insertCoustomer(Coustomer c) {
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="insert into coustomer_register (name, contact, address, email,password) values(?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setString(1, c.getName());
				ps.setLong(2, c.getContact());
				ps.setString(3, c.getAddress());
				ps.setString(4, c.getEmail());
				ps.setString(5, c.getPassword());
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
				String sql="select * from coustomer_register where email=?";
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
	
	public static Coustomer loginCoustomer(Coustomer c) {
		Coustomer c1=null;
		
		try {
					Connection conn=DBConnection.createConnection();
					String sql="select * from coustomer_register where email=? and password=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, c.getEmail());
					ps.setString(2, c.getPassword());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						c1 =new Coustomer();
						c1.setId(rs.getInt("id"));
						c1.setName(rs.getString("name"));
						c1.setContact(rs.getLong("contact"));
						c1.setAddress(rs.getString("address"));
						c1.setEmail(rs.getString("email"));
						c1.setPassword(rs.getString("password"));
					}
					
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return c1;
	}
	
	public static boolean checkOldPassword(String op,int id) {
		boolean flag=false;
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select * from coustomer_register where password=? and id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, op);
				ps.setInt(2, id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					flag=true;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public static void changePassword(String np,int id) {
		try {
				Connection conn=DBConnection.createConnection();
				String sql="update coustomer_register set  password=? where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
	
				ps.setString(1, np);
				ps.setInt(2,id);
				ps.executeUpdate();
				System.out.println("Password change successfully...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateCoustomerProfile(Coustomer c) {
			try {
					Connection conn=DBConnection.createConnection();
					String sql="update coustomer_register set name=?, contact=?, address=?, email=? where id=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					
					ps.setString(1, c.getName());
					ps.setLong(2, c.getContact());
					ps.setString(3, c.getAddress());
					ps.setString(4, c.getEmail());
					ps.setInt(5, c.getId());
					
					ps.executeUpdate();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void updateNewPassword(String cnp,String email) {
		try {
				Connection conn=DBConnection.createConnection();
				String sql="update coustomer_register set  password=? where email=?";
				PreparedStatement ps=conn.prepareStatement(sql);
	
				ps.setString(1, cnp);
				ps.setString(2,email);
				ps.executeUpdate();
				System.out.println("Password change successfully...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
