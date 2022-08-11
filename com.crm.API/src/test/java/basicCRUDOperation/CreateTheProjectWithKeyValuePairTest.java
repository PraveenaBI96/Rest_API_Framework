package basicCRUDOperation;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateTheProjectWithKeyValuePairTest {
@Test
public void createtheprojectwithkeyValuePair()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	RequestSpecification request=RestAssured.given();
	request.formParam("createdBy", "Praveen");
	request.formParam("projectName","Tyss"+random);
	request.formParam("status","Created");
	request.formParam("teamSize",18);
	
	request.contentType(ContentType.JSON);
	Response resp = request.post("http://localhost:8084/addProject");
	
	resp.then().log().all();
}
}
