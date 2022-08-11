package POJOforSerializationAndDeserialization;

public class SpouseDetailsArray {

String name;
String empId;
int phone;
String emailId;

public SpouseDetailsArray()
{
	
}
public SpouseDetailsArray(String name, String empId, int phone, String emailId) {
	this.name = name;
	this.empId = empId;
	this.phone = phone;
	this.emailId = emailId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

}
