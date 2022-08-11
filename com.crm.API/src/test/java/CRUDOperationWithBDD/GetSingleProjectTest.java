package CRUDOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest {
@Test
public void getSingleProject()
{
	//step 1 create the necessary data
	baseURI="http://localhost";
    port=8084;
	// step 2 send the request and Validate
	when()
	  .get("/projects/TY_PROJ_807")
	  .then()
	  .assertThat().statusCode(200).log().all();
}
}
