package CRUDOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DeleteAProjectTest {
@Test
public void deleteProject()
{
	//step 1 create the necessary data
	baseURI="http://localhost";
    port=8084;
	//step 2 send the request and validate
    when()
    .delete("/projects/TY_PROJ_804")
    .then()
    .assertThat().statusCode(204).log().all();
}
}
