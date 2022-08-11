package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
@Test
public void getDataUsingPathParamTest()
{
	baseURI = "http://localhost:8084";
	
	//step1 create prerequisites
	given()
	   .pathParam("proId", "TY_PROJ_1806")
	
	//send the request and validate
	.when()
	   .get("/projects/{proId}")
	.then().assertThat().statusCode(200).log().all();
}
}
