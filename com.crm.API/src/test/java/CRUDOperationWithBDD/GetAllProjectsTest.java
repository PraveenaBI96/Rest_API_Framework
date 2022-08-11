package CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetAllProjectsTest {
@Test
public void getAllProjects()
{
	//step 1 create necessary data
	baseURI="http://localhost";
    port=8084;
    
	//step 2 send request and validate
	when()
	  .get("/projects")
	   .then()
	   .assertThat().statusCode(200).log().all();
	   
	

}
}
