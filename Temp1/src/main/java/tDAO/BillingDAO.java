package tDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tDatabase.TDBConnection;
import tModel.Bill_Generate;
import tModel.Complain;

public class BillingDAO {
		
		public static void generateBill(Bill_Generate b) {
			
				try {
						
						Connection conn=TDBConnection.createConnection();
						String sql="insert into generate_bill (dobg,property_tax,water_charge,drainage_charge,street_light_charge,fire_charge,other_charge,total_amount) values(?,?,?,?,?,?,?,?)";
						PreparedStatement ps=conn.prepareStatement(sql);
						
						ps.setString(1,b.getDobg());
						ps.setInt(2, b.getProperty_tax());
						ps.setInt(3, b.getWater_charge());
						ps.setInt(4, b.getDrainage_charge());
						ps.setInt(5, b.getStreetlight_charge());
						ps.setInt(6, b.getFire_charge());
						ps.setInt(7, b.getOther_charge());
						ps.setInt(8, b.getTotal_amount());
						ps.executeUpdate();
						System.out.println("Bill Generate...");
						
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		public static  List<Bill_Generate> getBill(){
			ArrayList<Bill_Generate> bill = new ArrayList<Bill_Generate>();
			try {
					Connection conn = TDBConnection.createConnection();
					String sql = "select * from generate_bill";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						Bill_Generate b=new Bill_Generate();
						b.setBid(rs.getInt("bid"));
						b.setDobg(rs.getNString("dobg"));
						b.setProperty_tax(rs.getInt("property_tax"));
						b.setWater_charge(rs.getInt("water_charge"));
						b.setDrainage_charge(rs.getInt("drainage_charge"));
						b.setStreetlight_charge(rs.getInt("street_light_charge"));
						b.setFire_charge(rs.getInt("fire_charge"));
						b.setOther_charge(rs.getInt("other_charge"));
						b.setTotal_amount(rs.getInt("total_amount"));
						bill.add(b);
					}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return bill;
		}
}
