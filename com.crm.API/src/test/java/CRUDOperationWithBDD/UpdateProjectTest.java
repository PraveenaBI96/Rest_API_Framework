package CRUDOperationWithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest {
@Test
public void updateProject()
{
     baseURI="http://localhost";
     port=8084;
	Random r = new Random();
	int random = r.nextInt(500);
	
	//step 1 create necessary data
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Praveen");
	jObj.put("projectName", "rmgy"+random);
	jObj.put("status", "On Going");
	jObj.put("teamSize", 10);
	
	//step 2 send the request and validate
	given() 
	   .body(jObj)
	     .contentType(ContentType.JSON)
	     .when()
	        .put("/projects/TY_PROJ_1219")
	        .then()
	          .assertThat().statusCode(200).log().all();

}
}
