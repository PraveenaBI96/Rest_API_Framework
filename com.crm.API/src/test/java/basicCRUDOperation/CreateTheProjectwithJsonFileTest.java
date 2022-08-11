package basicCRUDOperation;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateTheProjectwithJsonFileTest {
@Test
public void createtheprojectwithJsonFile()
{
	RequestSpecification request = RestAssured.given();
	request.body(new File("C:\\Users\\Praveen\\Desktop\\requestBody.json"));
	
	request.contentType(ContentType.JSON);
	Response resp = request.post("http://localhost:8084/addProject");
	resp.then().log().all();
}
}

