package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteSingleProjectByusingPathParametreTest {
@Test
public void deleteSingleProjectByusingPathParametre()
{
	RequestSpecification request = RestAssured.given();
	
	request.pathParam("projId", "TY_PROJ_1212");
	
	Response resp = request.delete("http://localhost:8084/projects/{projId}");
	resp.then().log().all();
}
}
