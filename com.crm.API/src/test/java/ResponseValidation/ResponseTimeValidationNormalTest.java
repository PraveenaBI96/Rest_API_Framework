package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ResponseTimeValidationNormalTest {
@Test
public void responseTime()
{
	baseURI="http://localhost";
	port=8084;
	long expTime=800L;
	//step 1 send the request
	long time = when().get("projects").getTime();
	System.out.println(time);
	boolean flag = false;
    if(time<=expTime)
    {
    	flag=true;
    }
    Assert.assertTrue(flag);
}
}
