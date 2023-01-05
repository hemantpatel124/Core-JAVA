package tDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tDatabase.TDBConnection;
import tModel.Complain;
import tModel.Member;

public class ComplainDAO {
	
	public static void insertComplain(Complain c) {
		try {
				Connection conn=TDBConnection.createConnection();
				String sql="insert into complain (mid,doc,subject,complain,status) values(?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setInt(1, c.getMid());
				ps.setString(2, c.getDoc());
				ps.setString(3, c.getSubject());
				ps.setString(4, c.getComplain());
				ps.setString(5, c.getStatus());
				
				ps.executeUpdate();
				System.out.println("Complain successfully register...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  List<Complain> getPendingComplain(){
		ArrayList<Complain> pc_list = new ArrayList<Complain>();
		try {
			Connection conn = TDBConnection.createConnection();
			String sql = "select * from complain where status='Pending'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Complain c = new Complain();
				c.setCid(rs.getInt("cid"));
				c.setMid(rs.getInt("mid"));
				c.setDoc(rs.getString("doc"));
				c.setSubject(rs.getString("subject"));
				c.setComplain(rs.getString("complain"));
				c.setStatus(rs.getString("status"));
				pc_list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pc_list;
	}
	
	public static void replayComplain(Complain c) {
		
			try {
					Connection conn = TDBConnection.createConnection();
					String sql = "update complain set status='Solved', replay=?, dor=? where cid=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, c.getReplay());
					ps.setString(2, c.getDor());
					ps.setInt(3,c.getCid());
					ps.executeUpdate();
					System.out.println("Replay Complain..");
					
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static  List<Complain> getComplainByMid(int mid){
		ArrayList<Complain> pc_list = new ArrayList<Complain>();
		try {
			Connection conn = TDBConnection.createConnection();
			String sql = "select * from complain where mid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Complain c = new Complain();
				c.setCid(rs.getInt("cid"));
				c.setMid(rs.getInt("mid"));
				c.setDoc(rs.getString("doc"));
				c.setSubject(rs.getString("subject"));
				c.setComplain(rs.getString("complain"));
				c.setStatus(rs.getString("status"));
				pc_list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pc_list;
	}
	
}
