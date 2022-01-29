package dbs;
import java.sql.*;


public class ConnectionSetup
{
	static Connection con;
	public static Connection getCon()
	{
		
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String uname="root";
		String password ="root";
		con = DriverManager.getConnection(url,uname,password);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
}
}