package POJOClasses;

public class EmployeeLIbrary {
	//Step 1 declare all the keys and variables as global
String createdBy;
String projectName;
String status;
int teamSize;

//step 2 provide constructor to initialize the variables
public EmployeeLIbrary()
{
	
}

public EmployeeLIbrary(String createdBy, String projectName, String status, int teamSize) {
	this.createdBy = createdBy;
	this.projectName = projectName;
	this.status = status;
	this.teamSize = teamSize;
}

//step 3 provide getters and setters to access the variables
public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getTeamSize() {
	return teamSize;
}

public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}


}
