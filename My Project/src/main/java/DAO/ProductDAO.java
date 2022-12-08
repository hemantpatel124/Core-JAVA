package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DBConnection.DBConnection;
import Model.Product;

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
				
	
}
