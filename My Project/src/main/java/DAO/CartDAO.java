package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Model.Cart;
import Model.Product;

public class CartDAO {
	
	public static boolean checkProductIntoCart(int pid, int cusid) {
		boolean flag=false;
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select *from cart where pid=? and cusid=?";
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
	
	public static void insertIntoCart(Cart c) {		
			try {
					Connection conn=DBConnection.createConnection();
					String sql="insert into cart(pid,cusid) values(?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, c.getPid());
					ps.setInt(2, c.getCusid());
					ps.executeUpdate();
					System.out.println("insert into cart...");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static List<Cart> getCartListByCusid(int id){
			List<Cart> list=new ArrayList<Cart>();
			try {
					Connection conn=DBConnection.createConnection();
					String sql="select *from cart where cusid=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Cart c =new Cart();
						c.setCid(rs.getInt("cid"));
						c.setPid(rs.getInt("pid"));
						c.setCusid(rs.getInt("cusid"));
						list.add(c);
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
	public static List getProductByCart(int id) {
		List plist=new ArrayList();
		try {
				Connection conn=DBConnection.createConnection();
				String sql="SELECT *FROM product p,cart c WHERE c.pid=p.pid AND cusid=?";
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
	public static void shpoingCart() {
		
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
