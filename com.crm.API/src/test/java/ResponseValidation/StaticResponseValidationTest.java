package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
@Test
public void validateId()
{
	baseURI="http://localhost";
	port=8084;
	
	String expID="TY_PROJ_002";
	//step 1 send the request
	
	  Response resp=when().get("/projects");

	  String actId=resp.jsonPath().get("[1].projectId");
//	  Assert.assertEquals(actId, expID);
	    boolean flag = false;
	    if(actId.equalsIgnoreCase(expID))
	    {
	    	
	    	flag=true;
	    }
	    Assert.assertTrue(flag);
	  System.out.println("data verified");
	  resp.then().log().all();
}
}
