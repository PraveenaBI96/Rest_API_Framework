package DataProvider;

import org.testng.annotations.Test;

import POJOClasses.EmployeeLIbrary;
import genericUtility.DataProviderClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateMultipleProjectsWithSingleRequestTest {
@Test(dataProvider="getData",dataProviderClass=DataProviderClass.class)
public void createProjectTest(String createdBy, String projectName, String status, int teamSize)
{
	
	baseURI="http://localhost";
	port=8084;
	Random r = new Random();
	int random = r.nextInt(500);
	//step 1 create the data
	EmployeeLIbrary eLib = new EmployeeLIbrary(createdBy, projectName+random , status, teamSize);
	
	//step 2 send the request and validate
	
	given().body(eLib).contentType(ContentType.JSON)
	.when().post("/addProject")
	.then().log().all();
	
}
}