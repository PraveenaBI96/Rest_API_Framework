package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforSerializationAndDeserialization.EmployeeeWithSpouseDetailsObject;
import POJOforSerializationAndDeserialization.SpouseDetailsArray;

public class SerializationEmpWithSpouseTest {
	int []phnum= {13133,523887};
	String []mail= {"pravi@gmail.com","pravi@ty.com"};
	SpouseDetailsArray spouse= new SpouseDetailsArray("abcd", "Tys123", 324876, "abc@gmail.com");
	@Test
	public void serializationEmpwithSpouseArray() throws JsonGenerationException, JsonMappingException, IOException {
		EmployeeeWithSpouseDetailsObject emp= new EmployeeeWithSpouseDetailsObject("Praveen","Ty27",phnum,mail,"Bangalore",spouse);
		ObjectMapper obj= new ObjectMapper();
		obj.writeValue(new File("./EmployeeWithSpouse.json"), emp);
	}
}
