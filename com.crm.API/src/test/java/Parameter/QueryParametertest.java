package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParametertest {
@Test
public void getDataUsingQueryParamTest()
{
	baseURI="https://reqres.in/";
			
    //step 1 create the prerequisites
			given()
			    .queryParam("page", 2)
    // step 2 send the request and validate
			.when()
			  .get("api/users")
			.then().assertThat().statusCode(200).log().all();
}
}
