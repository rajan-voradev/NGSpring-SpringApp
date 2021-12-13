package dev.awesome.pdrep.model;

public class Cage {
	private String cageCode;
	private String duns;
	private String statusCode;
	private String companyName1;
	private String city;
	public String getCageCode() {
		return cageCode;
	}
	public void setCageCode(String cageCode) {
		this.cageCode = cageCode;
	}
	public String getDuns() {
		return duns;
	}
	public void setDuns(String duns) {
		this.duns = duns;
	}
	public String getCompanyName1() {
		return companyName1;
	}
	public void setCompanyName1(String companyName1) {
		this.companyName1 = companyName1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "Cage [cageCode=" + cageCode + ", duns=" + duns + ", statusCode=" + statusCode + ", companyName1="
				+ companyName1 + ", city=" + city + "]";
	}


}

