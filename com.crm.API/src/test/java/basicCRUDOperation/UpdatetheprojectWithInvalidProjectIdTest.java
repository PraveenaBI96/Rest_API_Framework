package basicCRUDOperation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdatetheprojectWithInvalidProjectIdTest {
@Test
public void updatetheprojectWithInvalidProjectId()
{
	Random r = new Random();
	int random = r.nextInt(500);
	//step 1 create necessary data
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "On Going");
	jObj.put("teamSize", 15);
	
	// step 2 send the request
	RequestSpecification request = RestAssured.given();
	request.body(jObj);
	request.contentType(ContentType.JSON);
	Response response = request.put("http://localhost:8084/projects/TY_PROJ_10070");
	
	//step 3 validate the response
	response.then().log().all();
}
}
