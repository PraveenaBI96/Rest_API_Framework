package CRUDOperationWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateTheProjectWithExistingProjectIDTest {
@Test
public void duplicateProject()
{
	 baseURI="http://localhost";
     port=8084;
	Random r = new Random();
	int random = r.nextInt(500);
	
	//Step 1 create the necessary data
	JSONObject jObj = new JSONObject();
	jObj.put("projectId", "TY_PROJ_1007");
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "Created");
	jObj.put("teamSize", 10);
	
	//Step 2 Send the request 
	  given()
	     .body(jObj)
	         .contentType(ContentType.JSON)
	        .when()
	             .post("/addProject")
	        .then()
	           .assertThat().statusCode(201).log().all();
	  
}
}
