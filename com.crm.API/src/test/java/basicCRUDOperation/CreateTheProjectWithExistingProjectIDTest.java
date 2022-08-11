package basicCRUDOperation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateTheProjectWithExistingProjectIDTest {
@Test
public void duplicateProject()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	//Step 1 create the necessary data
	JSONObject jObj = new JSONObject();
	jObj.put("projectId", "TY_PROJ_1007");
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "Created");
	jObj.put("teamSize", 10);
	
	//Step 2 Send the request 
	RequestSpecification request = RestAssured.given();
	request.body(jObj);
	request.contentType(ContentType.JSON);
	Response resp = request.post("http://localhost:8084/addProject");
	
	//Step 3 validate response 
	ValidatableResponse validate = resp.then();
	validate.log().all();
}
}
