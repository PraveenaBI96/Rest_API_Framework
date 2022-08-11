package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTheprojectWithInvalidProjectIdTest {
@Test
public void getTheprojectWithInvalidProjectId()
{
	//step 1 send the request
	Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_8080");
	//step 2 validate the response
	resp.then().log().all();
}
}
