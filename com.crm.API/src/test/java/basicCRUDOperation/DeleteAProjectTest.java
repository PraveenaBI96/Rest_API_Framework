package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteAProjectTest {
@Test
public void deleteProject()
{
	//step 1 create the necessary data
	
	//step 2 send the request
	Response response=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_808");
	
	//step 3 validate the response
	response.then().log().all();
}
}
