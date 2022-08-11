package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import POJOClasses.EmployeeLIbrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUpdateGetAndDeleteProjectTest {
	@Test
	public void createUpdateGetAndDeleteProject()
	{
		Random r = new Random();
		int random = r.nextInt(500);
		baseURI="http://localhost:8084";
		
		//step 1 create the necessary data
		EmployeeLIbrary emp = new EmployeeLIbrary("Praveen", "Dell"+random, "Created", 14);
		
		//step 2 send the request to create the project
		 Response resp = given().body(emp).contentType(ContentType.JSON)
		.when().post("/addProject");
		 resp.then().assertThat().statusCode(201).log().all();
		
		 Object projId = resp.jsonPath().get("projectId");
		
		//step 3 update details
		EmployeeLIbrary emp1 = new EmployeeLIbrary("Praveen", "Dell"+random, "Completed", 14);
		
		//step 4 send the request for update the project
		given().body(emp1).contentType(ContentType.JSON)
		.pathParam("proId", projId)
		.when().put("/projects/{proId}")
		.then().assertThat().statusCode(200).log().all();
		
		//step 5 get the project
		given().pathParam("proId", projId)
		 .when().get("/projects/{proId}")
		   .then().assertThat().statusCode(200).log().all();
		
		//step 6 delete the project
		given().pathParam("proId", projId)
		 .when().delete("/projects/{proId}")
		   .then().assertThat().statusCode(204).log().all();
	}
}
