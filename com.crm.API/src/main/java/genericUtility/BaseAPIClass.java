package genericUtility;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	public DataBaseUtility dLib= new DataBaseUtility();
	public JavaUtility jLib= new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public RestAssuredLibrary rLib =new RestAssuredLibrary();
	
@BeforeSuite
public void bsConfig() throws SQLException
{
	dLib.connectToDB();
	Reporter.log("====Connected to data base====",true);
	baseURI=IConstants.APP_URL;
	port=IConstants.APP_PORT;
}

@AfterSuite
public void asConfig() throws SQLException
{
	dLib.closeDB();
	Reporter.log("==== Connection closed====",true);
}
}
