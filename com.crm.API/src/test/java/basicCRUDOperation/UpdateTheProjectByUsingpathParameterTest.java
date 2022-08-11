package basicCRUDOperation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProjectByUsingpathParameterTest {
@Test
public void UpdateTheProjectByUsingpathParameter()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "Created");
	jObj.put("teamSize", 5);
	
	RequestSpecification request = RestAssured.given();
	request.body(jObj);
	request.contentType(ContentType.JSON);
	request.pathParam("projId", "TY_PROJ_1211");
	
	Response resp = request.put("http://localhost:8084/projects/{projId}");
	
	resp.then().log().all();
}
}
