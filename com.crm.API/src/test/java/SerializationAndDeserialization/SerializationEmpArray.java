package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforSerializationAndDeserialization.EmpDetailsArray;

public class SerializationEmpArray {
int []phnum= {13133,523887};
String []mail= {"pravi@gmail.com","pravi@ty.com"};
@Test
public void serializationEmpArray() throws JsonGenerationException, JsonMappingException, IOException {
	EmpDetailsArray emp= new EmpDetailsArray("Praveen","Ty27",phnum,mail,"Bangalore");
	ObjectMapper obj= new ObjectMapper();
	obj.writeValue(new File("./Employee1.json"), emp);
}
}
