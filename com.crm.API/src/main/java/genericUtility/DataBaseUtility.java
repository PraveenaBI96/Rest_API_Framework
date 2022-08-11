package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;

import com.mysql.cj.jdbc.Driver;
/**
 * this class consists of reusable methods to handle database
 * @author Praveen
 *
 */
public class DataBaseUtility {

	Driver driverRef;
	Connection con;
	/**
	 * this method is used for connect to database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(IConstants.DBURL,IConstants.DBUSERNAME,IConstants.DBPASSWORD);
	}
	/**
	 * this method is used for close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	public String readDataFromDBAndValidateDB(String query,int columnIndex,String expData) throws SQLException
	{
		 ResultSet result = con.createStatement().executeQuery(query);
		 boolean flag = false;
		 while(result.next())
		 {
			 if(result.getString(columnIndex).equals(expData))
			 {
				 flag=true;
				 break;
			 }
		 }
		if(flag)
		{
			Reporter.log("===Data Verified in DB===",true);
			return expData;
		}else
		{
			Reporter.log("===Data not present in DB===",true);
			return null;
		}	
	}
}
