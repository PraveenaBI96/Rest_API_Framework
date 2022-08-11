package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynomicResponseValidation {
	@Test
	public void validateId()
	{
		baseURI="http://localhost";
		port=8084;
		
		String expID="TY_PROJ_714";
		
		//step 1 send the request
		
		  Response resp=when().get("/projects");
		  List<String> list = resp.jsonPath().get("projectId"); 
		  boolean flag=false;
		  for(String actId:list)
		  {
			  if(actId.equalsIgnoreCase(expID))
			  {
				  System.out.println(actId);
				  flag = true;
				  break;
			  }
		  }
		  Assert.assertTrue(flag);
		  System.out.println("data validated");
	}
}
