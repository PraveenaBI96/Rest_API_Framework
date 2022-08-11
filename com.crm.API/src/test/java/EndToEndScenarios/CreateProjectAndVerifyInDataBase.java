package EndToEndScenarios;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import POJOClasses.EmployeeLIbrary;
import genericUtility.BaseAPIClass;
import genericUtility.EndpointsLibrary;
import genericUtility.IConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndVerifyInDataBase extends BaseAPIClass {
@Test
public void createProjectAndVerifyinDB() throws SQLException
{
	// step1 create the data 
	EmployeeLIbrary eLib = new EmployeeLIbrary("Praveen", "earthood"+jLib.randomNum(), "Created", 10);
	
	//step 2 send the request
    Response response = given().body(eLib).contentType(ContentType.JSON)
                        .when().post(EndpointsLibrary.CREATE_PROJECT);
    
    // step3 fetch the json data 
    String expData=rLib.getJsonData(response, "projectId");
    Reporter.log(expData,true);
     
    // validate the data in data base
    String actData = dLib.readDataFromDBAndValidateDB(IConstants.query, 1, expData);
    Assert.assertEquals(expData, actData);
     
    // get the data 
	given().pathParam("projId", expData)
	.when().get(EndpointsLibrary.GET_SINGLE_PROJECT+"{projId}")
	.then().assertThat().statusCode(200).log().all();
	
	//delete the project
	given().pathParam("projId", expData)
	  .when().delete(EndpointsLibrary.DELETE_PROJECT+"{projId}")
	  .then().assertThat().statusCode(204);
	
	// validate the data in data base
	actData = dLib.readDataFromDBAndValidateDB(IConstants.query, 1, expData);
    Assert.assertNull(actData);
}
}
