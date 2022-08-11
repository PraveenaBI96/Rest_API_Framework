package Authentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BarereToken {
@Test
public void loginAppUsingBarereToken()
{
	baseURI="https://api.github.com";
	
	// step 1 create prerequisites
	HashMap map = new HashMap();
	map.put("name", "Sdet36-RestRepo1");
	map.put("description", "RestAPITest");
	
	given().auth().oauth2("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")
	   .body(map).contentType(ContentType.JSON)
	   
	   // step 2 send the request and validate
       .when().post("/user/repos")
       .then().log().all();
}
}