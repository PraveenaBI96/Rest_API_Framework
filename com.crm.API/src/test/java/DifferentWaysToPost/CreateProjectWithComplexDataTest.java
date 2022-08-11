package DifferentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithComplexDataTest {
@Test
public void complexData()
{
	baseURI="https://petstore.swagger.io/v2";
	
	JSONObject cat= new JSONObject();
	cat.put("id", 245);
	cat.put("name","naveen");
	
	String [] photo={"https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg",
			"https://media.istockphoto.com/photos/colorful-sunset-at-davis-lake-picture-id1184692500"};
	
	JSONObject tag1= new JSONObject();
	tag1.put("id", 867);
	tag1.put("name","kiran");
	
	JSONObject tag2= new JSONObject();
	tag2.put("id", 647);
	tag2.put("name","mohan");
	
	Object []tag= {tag1,tag2};
	
	
		JSONObject jObj= new JSONObject();
		jObj.put("id", 1234);
		jObj.put("category", cat);
		jObj.put("name","Praveen");
		jObj.put("photoUrls", photo);
		jObj.put("tags",tag);
		jObj.put("status", "available");
	
	given()
	   .body(jObj)
	     .contentType(ContentType.JSON)
	 .when()
         .post("/pet")
      .then()
          .assertThat().statusCode(200) .log().all();
}
}
