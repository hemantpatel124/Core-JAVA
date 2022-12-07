package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Model.Seller;

public class AdminDAO {
	
	public static boolean checkEmail(String email) {
		boolean flag=false;
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select * from admin where email=?";
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
	
	public static Seller loginAdmin(Seller u) {
		Seller u1=null;
		
		try {
					Connection conn=DBConnection.createConnection();
					String sql="select * from admin where email=? and password=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, u.getEmail());
					ps.setString(2, u.getPassword());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						u1 =new Seller();
						u1.setEmail(rs.getString("email"));
						u1.setPassword(rs.getString("password"));
					}
					
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		return u1;
	}
	
	public static List<Seller> getAllSeller() {
		ArrayList<Seller> seller_list= new ArrayList<Seller>();
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select * from seller_register";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
			
				while(rs.next()) {
					Seller u2 =new Seller();
					u2.setId(rs.getInt("id"));
					u2.setName(rs.getString("name"));
					u2.setContact(rs.getLong("contact"));
					u2.setAddress(rs.getString("address"));
					u2.setEmail(rs.getString("email"));
					u2.setPassword(rs.getString("password"));
					seller_list.add(u2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return seller_list;
	}
	
	public static List<Seller> getAllCoustomer() {
		ArrayList<Seller> coustomer_list= new ArrayList<Seller>();
		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select * from coustomer_register";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
			
				while(rs.next()) {
					Seller u2 =new Seller();
					u2.setId(rs.getInt("id"));
					u2.setName(rs.getString("name"));
					u2.setContact(rs.getLong("contact"));
					u2.setAddress(rs.getString("address"));
					u2.setEmail(rs.getString("email"));
					u2.setPassword(rs.getString("password"));
					coustomer_list.add(u2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return coustomer_list;
	}
	
}
