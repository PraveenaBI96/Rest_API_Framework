package basicCRUDOperation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestChainingTest {
	String projId;
	RequestSpecification request;
@Test
public void createTheProject()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "Created");
	jObj.put("teamSize", 5);
	
	request = RestAssured.given();
	request.body(jObj);
	request.contentType(ContentType.JSON);
	Response resp = request.post("http://localhost:8084/addProject");
	projId=resp.getBody().jsonPath().getString("projectId");
	resp.then().log().all();
}
@Test(dependsOnMethods="createTheProject")
public void getTheProject()
{
	Response resp =request.get("http://localhost:8084/projects/"+projId);
	resp.then().log().all();
}
@Test(dependsOnMethods="getTheProject")
public void deleteTheProject()
{
	Response resp =request.delete("http://localhost:8084/projects/"+projId);
	resp.then().log().all();
}
}
