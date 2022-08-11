package basicCRUDOperation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatetheprojectWithStatusOngoingTest {
@Test
public void createtheprojectWithStatusOngoing()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "On Going");
	jObj.put("teamSize", 5);
	
	RequestSpecification request = RestAssured.given();
	request.body(jObj);
	request.contentType(ContentType.JSON);
	Response resp = request.post("http://localhost:8084/addProject");
	
	ValidatableResponse response=resp.then();
	response.log().all();
}
}
