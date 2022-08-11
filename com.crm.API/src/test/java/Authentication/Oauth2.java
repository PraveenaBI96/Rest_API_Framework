package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
@Test
public void oauth2Test()
{
	baseURI="http://coop.apps.symfonycasts.com";
	//step 1 generate access token
	Response resp = given()
	  .formParam("client_id", "SDET36-BI")
	  .formParam("client_secret", "d1abcc20d19d04c2d4349cbb1900c35b")
	  .formParam("grant_type", "client_credentials")
	  .formParam("redirect_uri", "http://example.com")
	  .formParam("code", "authorization_code")
	  .when()
	  .post("/token");
	
	// step 2 capture the access token
	String token = resp.jsonPath().get("access_token");
	
	//step 3 utilize the access token
    given().auth().oauth2(token)
         .pathParam("USER_ID", 3661)
     .when()
         .post("/api/{USER_ID}/eggs-count")
         
     .then().log().all();
}
}
