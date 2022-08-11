package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforSerializationAndDeserialization.EmpDetailsArray;

public class DeserializeEmpTest {
	
	@Test
	public void DeSerializeEmpArrayTest() throws JsonParseException, JsonMappingException, IOException
	{
      ObjectMapper obj = new ObjectMapper();
      EmpDetailsArray emp = obj.readValue(new File(".\\Employee1.json"), EmpDetailsArray.class);
      System.out.println(emp.getEmpId());
      System.out.println(emp.getPhone()[1]);
      System.out.println(emp.getEmailId()[0]);
	}
}
