package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRMGYantrawithoutAuthenticationTest {
	@Test
	public void loginApp()
	{
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8084/login");
		response.then().log().all();
	}
}
