package HiveProject;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveCreateTable {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		//Register driver and create dirver instance
		Class.forName(driverName);
		
		//get connection
		Connection conn = DriverManager.getConnection("jdbc:hive://localhost:10000/userdb","","");
		
		//create statement
		Statement stmt = conn.createStatement();
		
		//execute statement
		stmt.executeQuery("CREATE TABLE IF NOT EXISTS"
				+" employee (eid int, name String, salary String, destination String)"
				+" COMMENT 'Employee details'"
				+" ROW FORMAT DELIMITED"
				+" FIELDS TERMINATED BY '\t'"
				+" LINES TERMINATED BY '\n'"
				+" STORED AS TEXTFILE;");
		
		System.out.println(" Table employee created.");
		conn.close();
	}

}
