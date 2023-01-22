package cDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cDatabase.CDBConnection;
import cModel.Admin;
import cModel.Department;
import cModel.Student;

public class StudentDAO {

	public static void insertStudent(Student s) {
			
			try {
					Connection con=CDBConnection.createConnection();
					String sql="insert into student_reg (dcode,name,email,contact,city,password) values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, s.getDcode());
					ps.setString(2, s.getSname());
					ps.setString(3, s.getSemail());
					ps.setLong(4, s.getScontact());
					ps.setString(5, s.getScity());
					ps.setString(6, s.getSpassword());
					ps.executeUpdate();
					System.out.println("Student register successfull...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	public static boolean checkEmail(String email) {
		boolean flag=false;
		
		try {
				Connection conn=CDBConnection.createConnection();
				String sql="select * from student_reg where email=?";
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
	public static Student loginStudent(Student s) {
		Student s1=null;
		
		try {
					Connection conn=CDBConnection.createConnection();
					String sql="select * from student_reg where email=? and password=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, s.getSemail());
					ps.setString(2, s.getSpassword());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						s1 =new Student();	
						s1.setSid(rs.getInt("sid"));
						s1.setDcode(rs.getInt("dcode"));
						s1.setSname(rs.getString("name"));
						s1.setSemail(rs.getString("email"));
						s1.setScontact(rs.getLong("contact"));
						s1.setScity(rs.getString("city"));
						s1.setSpassword(rs.getString("password"));
					}
					
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		return s1;
	}
	
	public static void updateStudentProfile(Student s) {
		try {
				Connection conn=CDBConnection.createConnection();
				String sql="update student_reg set name=?, gender=?, email=? contact=?, city=? where sid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setString(1, s.getSname());
				ps.setString(2, s.getSgender());
				ps.setString(3, s.getSemail());
				ps.setLong(4, s.getScontact());
				ps.setString(5, s.getScity());
				ps.setInt(6, s.getSid());
				//ps.setDate(3, s.getSdob());
				ps.executeUpdate();
				System.out.println("Profile Update Successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void upadteProfilePhoto(Student s) {
		try {
				Connection conn=CDBConnection.createConnection();
				String sql="update student_reg set photo=? where sid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setString(1, s.getSphoto());
				ps.setInt(2, s.getSid());
				
				ps.executeUpdate();
				System.out.println("Profile Photo Updated...");
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  List<Student> getStudentByDcode(int dcode) {
		
		ArrayList<Student> f_list=new ArrayList<Student>();
		try {
				Connection con=CDBConnection.createConnection();
				String sql="select *from student_reg where dcode=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,dcode);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Student s=new Student();
					Department d=new Department();
					s.setDcode(rs.getInt("dcode"));
					s.setSname(rs.getString("name"));
					s.setSemail(rs.getString("email"));
					s.setScity(rs.getString("city"));
					f_list.add(s);
				}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return f_list;
	}
	
	
		
}
