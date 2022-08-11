package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforSerializationAndDeserialization.EmployeeeWithSpouseDetailsObject;

public class DeserializationEmpwithSpouseTest {
	@Test
	public void DeserializeEmpWithSpouseTest() throws JsonParseException, JsonMappingException, IOException
	{
	ObjectMapper obj = new ObjectMapper();
	EmployeeeWithSpouseDetailsObject emp = obj.readValue(new File(".\\EmployeeWithSpouse.json"), EmployeeeWithSpouseDetailsObject.class);
    System.out.println(emp.getEmpId());
    System.out.println(emp.getPhone()[1]);
    System.out.println(emp.getSpouse().getEmailId());
    System.out.println(emp.getSpouse().getName());
}
}