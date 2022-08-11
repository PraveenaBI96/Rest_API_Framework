package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {
@Test
public void loginRMGUsingBasicAuth()
{
	baseURI="http://localhost:8084";
	
	//step 1 create prerequisites
	given().auth().basic("rmgyantra", "rmgy@9999")
	
	// send login request
	.when().get("/login").then().assertThat().statusCode(202).log().all();
}
@Test
public void loginRMGUsingPreemptiveAuth()
{
	baseURI="http://localhost:8084";
	
	//step 1 create prerequisites
	given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
	
	// send login request
	.when().get("/login").then().assertThat().statusCode(202).log().all();
}
@Test
public void loginRMGUsingDigestiveAuth()
{
	baseURI="http://localhost:8084";
	
	//step 1 create prerequisites
	given().auth().digest("rmgyantra", "rmgy@9999")
	
	// send login request
	.when().get("/login").then().assertThat().statusCode(202).log().all();
}
}
