package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.JobApplication;
import com.dao.*;
import com.exception.DatabaseConnectionException;
public class JobApplicationService {
	 ApplicationDaoImpl impl=new  ApplicationDaoImpl ();

	public List<JobApplication> fetchAll() {
		List<JobApplication> list = impl.fetchAll();
		return list;
	}

	public JobApplication getjobById(List<JobApplication> list, int id) {
		for (JobApplication a : list) {
			if (a.getJobId() == id)
				return a;
	}
		return null;

}

	public void applyForJob(int applicantId, int jobId, String coverLetter) throws SQLException, DatabaseConnectionException {
		impl.insertJobApplication(applicantId, jobId, coverLetter);
	    
		
	}
}
