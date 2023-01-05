package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Model.*;
import Model.Product;

public class WishlistDAO {
	
	public static boolean checkProductIntoWishlist(int pid, int cusid) {
		boolean flag=false;
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select *from wishlist where pid=? and cusid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, pid);
				ps.setInt(2, cusid);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
						
					flag=true;
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return  flag;
	}
	
	public static void insertIntoWishlist(Wishlist w) {		
		try {
				Connection conn=DBConnection.createConnection();
				String sql="insert into wishlist(pid,cusid) values(?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, w.getPid());
				ps.setInt(2, w.getCusid());
				ps.executeUpdate();
				System.out.println("insert into wislist...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Wishlist> getWishListByCusid(int id){
		List<Wishlist> list=new ArrayList<Wishlist>();
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select *from wishlist where cusid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Wishlist w =new Wishlist();
					w.setWid(rs.getInt("wid"));
					w.setPid(rs.getInt("pid"));
					w.setCusid(rs.getInt("cusid"));
					list.add(w);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List getProductByWishlist(int id) {
		List plist=new ArrayList();
		try {
			Connection conn=DBConnection.createConnection();
			String sql="SELECT *FROM product p,wishlist w WHERE w.pid=p.pid AND cusid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt("pid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getDouble("pprice"));
				p.setSid(rs.getInt("sid"));
				plist.add(p);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plist;
	}
}
