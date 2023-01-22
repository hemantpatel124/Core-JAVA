package cDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cDatabase.CDBConnection;
import cModel.Department;

public class DepartmentDAO {
		public static  List<Department> getDepartment() {
			ArrayList<Department> d_list=new ArrayList<Department>();
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select * from department";
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						Department d=new Department();
						d.setDcode(rs.getInt("dcode"));
						d.setDname(rs.getString("dname"));
						d_list.add(d);
					}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return d_list;
		}
		public static String getDepartmentNameByDcode(int d) {
			String dname=null;
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select *from department where dcode=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,d);
					ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					dname=rs.getString("dname");
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return dname;
		}
}
