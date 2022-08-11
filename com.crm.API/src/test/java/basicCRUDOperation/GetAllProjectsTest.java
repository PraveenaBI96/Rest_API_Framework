package basicCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {
@Test
public void getAllProjects()
{
	//step 1 create necessary data
	
	//step 2 send request
	Response response = RestAssured.get("http://localhost:8084/projects");
	
	//step 3 validate the response
	response.then().log().all();
}
}
