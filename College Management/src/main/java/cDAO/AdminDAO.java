package cDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cDatabase.CDBConnection;
import cModel.Admin;
import cModel.Department;
import cModel.Faculty;
import cModel.Student;

public class AdminDAO {
		public static boolean checkEmail(String email) {
				boolean flag=false;
				
				try {
						Connection conn=CDBConnection.createConnection();
						String sql="select * from admin_master where email=?";
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

		public static Admin loginAdmin(Admin a) {
			Admin a1=null;
			
			try {
						Connection conn=CDBConnection.createConnection();
						String sql="select * from admin_master where email=? and password=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, a.getEmail());
						ps.setString(2, a.getPassword());
						ResultSet rs=ps.executeQuery();
						
						if(rs.next()) {
							a1 =new Admin();
							a1.setAid(rs.getInt("aid"));
							a1.setEmail(rs.getString("email"));
							a1.setPassword(rs.getString("password"));
						}
						
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			return a1;
		}
		
		
}
