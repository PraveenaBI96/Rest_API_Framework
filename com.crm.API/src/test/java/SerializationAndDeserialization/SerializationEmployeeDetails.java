package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforSerializationAndDeserialization.EmployeeDetails;

public class SerializationEmployeeDetails {
	@Test
public void serializatonEmployeeDetailsTest() throws JsonGenerationException, JsonMappingException, IOException
{
// Step 1:Create object of POJO and provide values
	EmployeeDetails emp= new EmployeeDetails("Praveen", "TY1234", 18728628, "praveen@gmail.com", "abdsdhs");
// Step 2:	Create object of Object Mapper for Jackson Mapper
	ObjectMapper obj = new ObjectMapper();
//	Step 3: write data into json file
	obj.writeValue(new File("./EmployeeDetails.json"), emp);
	
}
}
