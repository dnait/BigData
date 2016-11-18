package HiveProject;
import java.sql.SQLException;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveCreateDb {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Register driver and create driver instance
		Class.forName(driverName);
		
		//getconnection->createStatement->executeQuery(sql)
		Connection conn = DriverManager.getConnection("jdbc:hive://localhost:10000/default","","");
		Statement stmt = conn.createStatement();
		stmt.executeQuery("CREATE DATABASE userdb");
		
		System.out.println("Database userdb created successfully");
		
		//close the connection
		conn.close();
		
		
	}
	

}
