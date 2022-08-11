package Parameter;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class FormParameterTest {
@Test
public void createProjectUsingFormParam()
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
