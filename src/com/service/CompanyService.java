package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.exception.DatabaseConnectionException;
import com.model.Company;
import com.model.JobListing;
public class CompanyService {
	CompanyDaoImpl companyimpl=new CompanyDaoImpl();
	public void postJob(String des, String loc, double salary, String type) throws SQLException, DatabaseConnectionException {
		companyimpl.postJob(des,loc,salary,type);
		
	}
	public List<JobListing> getJobs() throws SQLException, DatabaseConnectionException {
		return companyimpl.getJobs();
		
		
	}
	public List<Company> getCompany() throws SQLException, DatabaseConnectionException {
		
		return companyimpl.getCompany();
	}

}
