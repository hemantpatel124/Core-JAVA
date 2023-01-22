package cDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class CDBConnection {
	public static Connection createConnection() {
		Connection conn=null;
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_management", "root", "");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
