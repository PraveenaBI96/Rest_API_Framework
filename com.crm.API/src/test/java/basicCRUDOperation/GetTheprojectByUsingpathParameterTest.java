package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTheprojectByUsingpathParameterTest {
@Test
public void getTheprojectByUsingpathParameter()
{
	RequestSpecification request = RestAssured.given();
	
	request.pathParam("projId", "TY_PROJ_1211");
	
	Response resp = request.get("http://localhost:8084/projects/{projId}");
	resp.then().log().all();
}
}
