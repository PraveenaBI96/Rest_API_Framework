package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateTheProjectWithFormParameterTest {
@Test
public void createProject()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	baseURI="http://localhost";
	port=8084;
	//step 1 create the data
	given()
	 .formParam("createdBy", "praveen")
	 .formParam("projectName", "rmysd"+random)
	 .formParam("status", "Completed")
	 .formParam("teamSize", 18)
	 .contentType(ContentType.JSON)
	.when()
	  .post("/addProject")
	.then().assertThat().statusCode(201).log().all();
 }
}
