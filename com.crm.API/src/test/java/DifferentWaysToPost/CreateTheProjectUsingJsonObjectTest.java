package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateTheProjectUsingJsonObjectTest {
	@Test
	public void createProject()
	{
		  baseURI="http://localhost";
		  port=8084;
		Random r = new Random();
		int random = r.nextInt(500);
		
		//Step 1 create the necessary data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Praveen");
		jObj.put("projectName", "rmgy"+random);
		jObj.put("status", "Created");
		jObj.put("teamSize", 10);
		//step 2 send the request and validate
	  given()
	     .body(jObj)
	         .contentType(ContentType.JSON)
	        .when()
	             .post("/addProject")
	        .then()
	           .assertThat().statusCode(201).log().all();
	  
	}
}
