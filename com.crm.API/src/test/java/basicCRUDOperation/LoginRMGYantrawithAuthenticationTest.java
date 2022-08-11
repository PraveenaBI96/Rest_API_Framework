package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRMGYantrawithAuthenticationTest {
@Test
public void loginApp()
{
	RequestSpecification request = RestAssured.given();
	request.auth().basic("rmgyantra", "rmgy@9999");
	Response response = request.get("http://localhost:8084/login");
	response.then().log().all();
}
}
