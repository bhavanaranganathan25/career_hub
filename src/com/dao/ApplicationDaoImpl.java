package com.dao;

import java.sql.Connection;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.JobApplication;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBUtility;

public class ApplicationDaoImpl {

	public List<JobApplication> fetchAll() {
		
		return null;
	}

	public void insertJobApplication(int applicantId, int jobId, String coverLetter) throws SQLException, DatabaseConnectionException {
	        String sql = "insert into jobapllication (applicant_id, joblisting_id, cover_letter) VALUES (?, ?, ?)";
	        Connection conn=DBUtility.getDbConn();
	        PreparedStatement ps=conn.prepareStatement(sql);  
	            ps.setInt(1, applicantId);
	            ps.setInt(2, jobId);
	            ps.setString(3, coverLetter);
	            ps.executeUpdate();
	            int rst=ps.executeUpdate();
	
	DBUtility.DBClose();	
	}
}
