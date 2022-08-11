package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationTest {
	@Test
	public void responseTime()
	{
		baseURI="http://localhost";
		port=8084;
		
		//step 1 send the request
	    when().get("projects")
	    .then().assertThat().time(Matchers.lessThan(800L), TimeUnit.MILLISECONDS)
	    .log().all();
		
	}
}
