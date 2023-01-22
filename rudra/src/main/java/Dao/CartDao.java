package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionDB.DBConnection;
import Model.Cart;

public class CartDao {
	public static void insetIntoCart(Cart c) {
		try {
			Connection conn = DBConnection.craetConnection();
			String sql="insert into cart(pid,cusid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getPid());
			pst.setInt(2, c.getCusid());
			pst.executeUpdate();
			System.out.println("inserted into cart");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Cart> getCartListByCusId(int id){
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection conn = DBConnection.craetConnection();
			String sql="select * from cart where cusid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
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
}