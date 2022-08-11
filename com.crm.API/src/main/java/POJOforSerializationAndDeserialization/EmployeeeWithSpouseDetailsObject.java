package POJOforSerializationAndDeserialization;

public class EmployeeeWithSpouseDetailsObject {

	String name;
	String empId;
	int []phone;
	String []emailId;
	String address;
	SpouseDetailsArray spouse;
	
	public EmployeeeWithSpouseDetailsObject()
	{
		
	}

	public EmployeeeWithSpouseDetailsObject(String name, String empId, int[] phone, String[] emailId, String address,
			SpouseDetailsArray spouse) {
		this.name = name;
		this.empId = empId;
		this.phone = phone;
		this.emailId = emailId;
		this.address = address;
		this.spouse = spouse;
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
	public int[] getPhone() {
		return phone;
	}
	public void setPhone(int[] phone) {
		this.phone = phone;
	}
	public String[] getEmailId() {
		return emailId;
	}
	public void setEmailId(String[] emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public SpouseDetailsArray getSpouse() {
		return spouse;
	}

	public void setSpouse(SpouseDetailsArray spouse) {
		this.spouse = spouse;
	}

}
