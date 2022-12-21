package sDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sModel.Member;
import sdatabaseConnection.SDBConnection;

public class AdminDAO {

	public static List<Member> getApprovedRequest() {
		ArrayList<Member> requestList = new ArrayList<Member>();
		
		try {
					Connection conn=SDBConnection.createConnection();
					String sql="select *from member_reg";
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						Member m=new Member();
						
						m.setTemp_id(rs.getInt("tid"));
						m.setName(rs.getString("name"));
						m.setEmail(rs.getString("email"));
						m.setContact(rs.getLong("contact"));
						m.setFlno(rs.getString("flno"));
					
						m.setProf(rs.getString("prof"));
						m.setFmno(rs.getInt("fmno"));
						m.setAddress(rs.getString("address"));
						
						requestList.add(m);
					}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return requestList;
	}
	
//	public static void approvedMember() {
//		Member m=new Member();
//		
//		try {
//				Connection conn=SDBConnection.createConnection();
//				String sql="INSERT INTO `member_reg`(`name`, `email`, `contact`, `flno`, `prof`, `fmno`, `address`, `password`) SELECT `name`, `email`, `contact`, `flno`, `prof`, `fmno`, `address`, `password` FROM temp_member_reg;";
//				PreparedStatement ps=conn.prepareStatement(sql);
//				ps.executeUpdate();
//				System.out.println("Data Inserted...");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static void deleteMemberByTid(int id) {
//		try {
//				Connection conn=SDBConnection.createConnection();
//				String sql ="delete from temp_member_reg where tid=?";
//				PreparedStatement pst = conn.prepareStatement(sql);
//				pst.setInt(1, id);
//				pst.executeUpdate();
//				System.out.println("data deleted");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	}
	

}
