package CRUDOperationWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetProjectInsameRequestTest {
@Test
public void createProjectAndGetProjectInsameRequest()
{
	baseURI="http://localhost";
    port=8084;
    
	Random r = new Random();
	int random = r.nextInt(500);
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "Created");
	jObj.put("teamSize", 5);
	
	Response res= given()
	   .body(jObj)
	     .contentType(ContentType.JSON)
        .when()
           .post("/addProject");
	        String projID= res.getBody().jsonPath().getString("projectId");
               when()
                .get("/projects/"+projID)
                .then()
                  .assertThat().statusCode(200).log().all();
	
}
}
