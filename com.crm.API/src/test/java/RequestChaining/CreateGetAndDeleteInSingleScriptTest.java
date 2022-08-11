package RequestChaining;

import org.testng.annotations.Test;

import POJOClasses.EmployeeLIbrary;
import POJOforSerializationAndDeserialization.EmployeeDetails;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateGetAndDeleteInSingleScriptTest {
@Test
public void createGetAndDeleteProject()
{
	Random r = new Random();
	int random = r.nextInt(500);
	baseURI="http://localhost:8084";
	
	//step 1 create the necessary data
	EmployeeLIbrary emp = new EmployeeLIbrary("Praveen", "Dell"+random, "On Going", 14);
	
	//step 2 send the request to create the project
	 Object proId = given()
	   .body(emp)
	   .contentType(ContentType.JSON)
	 .when().post("/addProject")
	 .jsonPath().get("projectId");
		 
	// step 3 send the request to get the project
	 
	 
//	 when().get("/projects/"+proId)
//	    .then().assertThat().statusCode(200).log().all();
	given().pathParam("projId",proId)
	 .when().get("/projects/{projId}")
	   .then().assertThat().statusCode(200).log().all();
	
	//step 3 send the request to delete the project
	given().pathParam("projId",proId)
	   .when().delete("/projects/{projId}")
	    .then().assertThat().statusCode(204).log().all();
}
}
