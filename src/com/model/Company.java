package com.model;

public class Company {
	private int companyId;
	private int companyName;
	private int location;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int companyId, int companyName, int location) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.location = location;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCompanyName() {
		return companyName;
	}
	public void setCompanyName(int companyName) {
		this.companyName = companyName;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", location=" + location + "]";
	}
	
	

}
