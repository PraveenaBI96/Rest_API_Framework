package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateTheProjectWithJsonFileTest {
	@Test
	public void createtheprojectwithJsonFile()
	{
	    baseURI="http://localhost";
	    port=8084;
	    //step 1 create the data
	    File file= new File(".\\src\\test\\resources\\RequestData.json");
	    
	    //step 2 send the request and validate response
	    given()
		  .body(file)
		   .contentType(ContentType.JSON)
		 .when()
		    .post("/addProject")
		       .then()
		          .assertThat().statusCode(201).log().all();
	}
}
