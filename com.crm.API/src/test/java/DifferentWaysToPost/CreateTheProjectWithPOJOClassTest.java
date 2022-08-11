package DifferentWaysToPost;

import java.util.Random;

import org.testng.annotations.Test;

import POJOClasses.EmployeeLIbrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateTheProjectWithPOJOClassTest {
@Test
public void createProject() {
	baseURI="http://localhost";
	  port=8084;
	Random r = new Random();
	int random = r.nextInt(500);
	
	//step 1 create the data 
	EmployeeLIbrary eLib = new EmployeeLIbrary("Praveen", "Tyss"+random, "On Going", 5);

	// step 2 send the request and validate the response
	given()
	  .body(eLib)
      .contentType(ContentType.JSON)
    .when()
      .post("/addProject")
     .then().assertThat().statusCode(201).log().all();  
}
}
