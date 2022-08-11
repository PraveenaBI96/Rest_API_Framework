package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforSerializationAndDeserialization.EmployeeDetails;

public class DeserializationEmployeeDetailsTest {
    @Test
	public void deSerializationofEmpDetailsTest() throws JsonParseException, JsonMappingException, IOException
	{
		// step 1: create object of Object Mapper
    	ObjectMapper obj=new ObjectMapper();
        // step 2: read value from object mapper
        EmployeeDetails e1 = obj.readValue(new File(".\\EmployeeDetails.json"),EmployeeDetails.class);
    	// step 3: fetch the required value from class
    	System.out.println(e1.getEname());
    	System.out.println(e1.getPhone());
    	System.out.println(e1.getEmpId());
	}
}
