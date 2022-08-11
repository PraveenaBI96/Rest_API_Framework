package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateTheProjectWithHashMapTest {
@Test
public void createProject()
{
	Random r = new Random();
	int random = r.nextInt(500);
	
	baseURI="http://localhost";
	port =8084;
	//step 1 create the data
	HashMap<String,Object> map = new HashMap<String,Object>();
	map.put("createdBy", "Praveen");
	map.put("projectName","tyss"+random);
	map.put("status", "Created");
	map.put("teamSize", 10);
	//step 2 send the Request and Validate the Response
	
	given()
	 .body(map)
	  .contentType(ContentType.JSON)
	.when()
	  .post("/addProject")
	.then().assertThat().statusCode(201).log().all();
}
}
