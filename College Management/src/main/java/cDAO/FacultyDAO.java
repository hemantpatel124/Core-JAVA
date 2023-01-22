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
import cModel.Subject;

public class FacultyDAO {
		public static void insertFaculty(Faculty f) {
			
			try {
					Connection con=CDBConnection.createConnection();
					String sql="insert into faculty_reg (dcode,name,email,contact,city,password) values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, f.getDcode());
					ps.setString(2, f.getFname());
					ps.setString(3, f.getFemail());
					ps.setLong(4, f.getFcontact());
					ps.setString(5, f.getFcity());
					ps.setString(6, f.getFpassword());
					ps.executeUpdate();
					System.out.println("Registration successfull...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		public static boolean checkEmail(String email) {
			boolean flag=false;
			
			try {
					Connection conn=CDBConnection.createConnection();
					String sql="select * from faculty_reg where email=?";
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
		public static Faculty loginFaculty(Faculty f) {
			Faculty f1=null;
			
			try {
						Connection conn=CDBConnection.createConnection();
						String sql="select * from faculty_reg where email=? and password=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, f.getFemail());
						ps.setString(2, f.getFpassword());
						ResultSet rs=ps.executeQuery();
						
						if(rs.next()) {
							f1 =new Faculty();
							f1.setFid(rs.getInt("fid"));
							f1.setDcode(rs.getInt("dcode"));
							f1.setFname(rs.getString("name"));
							f1.setFemail(rs.getString("email"));
							f1.setFcontact(rs.getLong("contact"));
							f1.setFcity(rs.getString("city"));
							f1.setFpassword(rs.getString("password"));
						}
						
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			return f1;
		}
		public static  List<Faculty> getFaculty() {
			ArrayList<Faculty> f_list=new ArrayList<Faculty>();
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select  department.dcode,department.dname, faculty_reg.fid, faculty_reg.name from department, faculty_reg WHERE department.dcode=faculty_reg.dcode;";
					PreparedStatement ps=con.prepareStatement(sql);
				
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						Faculty f=new Faculty();
						f.setFid(rs.getInt("fid"));
						f.setDcode(rs.getInt("dcode"));
						f.setFname(rs.getString("name"));
						f_list.add(f);
					}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return f_list;
		}
		public static Faculty getFacultyByDcode(int d) {
			Faculty f=new Faculty();
			//String fname=null;
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select *from faculty_reg where dcode=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,d);
					ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					f.setDcode(rs.getInt("dcode"));
					f.setFname(rs.getString("name"));
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
		public static Faculty getSubjectByDcode(int d) {
			Faculty f=new Faculty();
			//String fname=null;
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select *from faculty_reg where dcode=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,d);
					ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					f.setDcode(rs.getInt("dcode"));
					f.setFname(rs.getString("name"));
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
		
		public static  List<Subject> getSubjectByFacultyid(int d) {
			ArrayList<Subject> sub_list=new ArrayList<Subject>();
			try {
						Connection con=CDBConnection.createConnection();
						String sql="select *from subject where fid=?";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,d);
						ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
							Subject s=new Subject();
							s.setSubid(rs.getInt("subid"));
							s.setDcode(rs.getInt("dcode"));
							s.setFid(rs.getInt("fid"));
							s.setSemester(rs.getInt("semester"));
							s.setSubname(rs.getString("sub_name"));
							sub_list.add(s);
					}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return sub_list;
		}
		public static String getFacultyNameById(int d) {
			String fname=null;
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select *from faculty_reg where fid=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,d);
					ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					fname=rs.getString("name");
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return fname;
		}
		public static  List<Faculty> getFaculty(int f) {
			ArrayList<Faculty> f_list=new ArrayList<Faculty>();
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select  *from faculty_reg WHERE dcode=?;";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, f);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						Faculty f1=new Faculty();
						f1.setFid(rs.getInt("fid"));
						f1.setDcode(rs.getInt("dcode"));
						f1.setFname(rs.getString("name"));
						f_list.add(f1);
					}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return f_list;
		}
		
		
		public static int getSubjectCodeByFacultyId(int d) {
				int subid=0;
			try {
					Connection con=CDBConnection.createConnection();
					String sql="select *from subject where fid=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,d);
					ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					subid=rs.getInt("fid");
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return subid;
		}
		
		
}
