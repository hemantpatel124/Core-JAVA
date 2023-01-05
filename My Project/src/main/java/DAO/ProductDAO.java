package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import DBConnection.DBConnection;
import Model.Product;
import Model.Seller;

public class ProductDAO {

	public static void insertPRoduct(Product p) {
				
				try {
						
						Connection conn=DBConnection.createConnection();
						String sql="insert into product (sid, image, pname, pprice,pcategory) values(?,?,?,?,?)";
						PreparedStatement ps=conn.prepareStatement(sql);
						
						ps.setInt(1, p.getSid());
						ps.setString(2, p.getImage());
						ps.setString(3, p.getPname());
						ps.setDouble(4, p.getPrice());
						ps.setString(5, p.getPcategory());
						ps.executeUpdate();
						System.out.println("product uploaded");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
	}
	public static List <Product> getProductBySid(int sid){
			ArrayList<Product> product_list= new ArrayList<Product>();
				
			try {
						Connection conn=DBConnection.createConnection();
						String sql="select *from product where sid=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setInt(1, sid);
						ResultSet rs=ps.executeQuery();
						
						while (rs.next()) {
							Product p=new Product();
							p.setPid(rs.getInt("pid"));
							p.setSid(rs.getInt("sid"));
							p.setImage(rs.getString("image"));
							p.setPname(rs.getString("pname"));
							p.setPrice(rs.getDouble("pprice"));
							p.setPcategory(rs.getString("pcategory"));
							product_list.add(p);
						}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
			return product_list;
	}
	
	public static Product getDataByPid(int id) {
		Product p=null;
		try {
				Connection conn=DBConnection.createConnection();
				String sql="select * from product where pid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
			
				if(rs.next()) {
					p =new Product();
					p.setPid(rs.getInt("pid"));
					p.setSid(rs.getInt("sid"));
					p.setImage(rs.getString("image"));
					p.setPname(rs.getString("pname"));
					p.setPrice(rs.getDouble("pprice"));
					p.setPcategory(rs.getString("pcategory"));
				}
			
			} catch (Exception e1) {
					e1.printStackTrace();
			}
				return p;
		}
	
		public static void updateProduct(Product p) {
			try {
					Connection conn=DBConnection.createConnection();
					String sql="update product set image=?, pname=?, pprice=?,pcategory=? where pid=?";
					PreparedStatement ps=conn.prepareStatement(sql);
			
					ps.setString(1, p.getImage());
					ps.setString(2, p.getPname());
					ps.setDouble(3, p.getPrice());
					ps.setString(4, p.getPcategory());
					ps.setInt(5, p.getPid());
					ps.executeUpdate();
					System.out.println("Data updated...");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void productDelete(int id) {
			try {
						Connection conn=DBConnection.createConnection();
						String sql="delete from  product  where pid=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
						System.out.println("Data delete!!!");
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public static List <Product> getAllProduct(){
			ArrayList<Product> product_list= new ArrayList<Product>();
				
			try {
						Connection conn=DBConnection.createConnection();
						String sql="select *from product";
						PreparedStatement ps=conn.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						
						while (rs.next()) {
							Product p=new Product();
							p.setPid(rs.getInt("pid"));
							p.setSid(rs.getInt("sid"));
							p.setImage(rs.getString("image"));
							p.setPname(rs.getString("pname"));
							p.setPrice(rs.getDouble("pprice"));
							p.setPcategory(rs.getString("pcategory"));
							product_list.add(p);
						}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return product_list;
		}
	
}
