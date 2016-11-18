package HiveProject;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class selectWhere {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection("jdbc:hive://localhost:10000/userdb","","");
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM employee WHERE salary > 30000;");
		
		System.out.println("Result: ");
		System.out.println("ID \t Name \t Salary \t Designation \t Dept");
		
		while (res.next()) {
			System.out.println(res.getInt(1) + " " + res.getString(2)
			+ " " + res.getDouble(3) + " " + res.getString(4) + " " 
			+ res.getString(5));
		}
		
		

	}

}
