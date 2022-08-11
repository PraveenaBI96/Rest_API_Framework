package POJOforSerializationAndDeserialization;

public class EmployeeDetails {


// Step 1:declare all the variables as global
	String ename;
	String empId;
	int phone;
	String email;
	String address;
	
	public EmployeeDetails()
	{	
	}
//	Step 2: Create a constructor to initialize all the variables
	public EmployeeDetails(String ename, String empId, int phone, String email, String address) {
		this.ename = ename;
		this.empId = empId;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
//	Step 3: provide getters and setters to access the variables

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
