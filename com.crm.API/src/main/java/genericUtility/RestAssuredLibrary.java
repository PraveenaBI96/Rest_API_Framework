package genericUtility;

import io.restassured.response.Response;

/**
 * this class consists of reusable restassured methods
 * @author Praveen
 *
 */
public class RestAssuredLibrary {
	/**
	 * this method will get the json data through json path from response body
	 * @param response
	 * @param path
	 * @return
	 */
public String getJsonData(Response response,String path)
{
	String jsonData=response.jsonPath().get(path);
	return jsonData;
}
}
