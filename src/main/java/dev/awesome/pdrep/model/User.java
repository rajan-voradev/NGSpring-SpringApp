package dev.awesome.pdrep.model;

public class User {
	private String userCode;
	private String firstName;
	private String lastName;
	private String city;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [userCode=" + userCode + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ "]";
	}
	
	
}
