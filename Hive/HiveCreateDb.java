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
		
		//getconnection -> createStatement -> executeQuery(sql)
		Connection conn = DriverManager.getConnection("jdbc:hive://localhost:10000/default","","");
		Statement stmt = conn.createStatement();
		
		//create
		stmt.executeQuery("CREATE DATABASE userdb");
		
//	    stmt.executeQuery("ALTER TABLE employee RENAME TO emp;");
//	    System.out.println("Table Renamed Successfully");
		
//		stmt.executeQuery("DROP TABLE IF EXISTS employee;");
//	    System.out.println("Drop table successful.");
		
		System.out.println("Database userdb created successfully");
		
		//close the connection
		conn.close();
		
		
	}
	

}
