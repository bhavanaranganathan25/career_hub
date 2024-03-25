package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.model.Applicant;
import com.model.JobListing;
public class JobListingService {
	JobListingDaoImpl jobimpl=new JobListingDaoImpl();
	public void apply(int id, String coverLetter) throws SQLException {
		jobimpl.apply(id,coverLetter);
		
		
	}
	public List<Applicant> getApplicant() throws SQLException {
		
		return jobimpl.getApplicant();
	}
	public List<JobListing> getJobListings() throws SQLException {
		
		return jobimpl.getJobListings();
	}
	public List<JobListing> getJobListingsBySalaryRange(double minSalary, double maxSalary) throws SQLException {
		return jobimpl.getJobListingsBySalaryRange(minSalary, maxSalary);
	    
	}

}
