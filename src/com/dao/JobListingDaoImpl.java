package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Applicant;
import com.model.JobListing;
import com.util.DBUtility;

public class JobListingDaoImpl {


	public void apply(int id, String coverLetter) throws SQLException {
		Connection conn=DBUtility.getDBConn();
		String sql="select id, cover_letter from jobapllication";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rst=ps.executeQuery();
		if(rst.next()) {
			int jid=rst.getInt("id");
			String coverletter=rst.getString("cover_letter");
			
		}
		DBUtility.dbClose();
		
	}

	public List<Applicant> getApplicant() throws SQLException {
		List<Applicant> list=new ArrayList<>();
		Connection conn=DBUtility.getDBConn();
		String sql="select*from applicant";
		PreparedStatement ps=conn.prepareStatement(sql);
		 
		
		ResultSet rst=ps.executeQuery();
		while(rst.next()) {
			int applicantId=rst.getInt("id");
			String firstName=rst.getString("first_name");
			String lastName=rst.getString("last_name");
			String email=rst.getString("email");
			String phone=rst.getString("phone");
			String resume=rst.getString("resume");
		    Applicant applicant=new Applicant(applicantId,firstName,lastName,email,phone,resume);
		    list.add(applicant);
		}
		DBUtility.dbClose();
		return list;
	}

	public List<JobListing> getJobListings() throws SQLException {
		List<JobListing> list = new ArrayList<>();
		Connection conn=DBUtility.getDBConn();
		String sql="select * from joblisting";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rst=ps.executeQuery();
		while(rst.next()) {
			int id=rst.getInt("id");
			String title=rst.getString("job_title");
			String description=rst.getString("job_description");
			String location =rst.getString("job_location");
			Double salary=rst.getDouble("salary");
			String jobType=rst.getString("job_type");
			LocalDate postdate=rst.getDate("posted_date").toLocalDate();
			int cid=rst.getInt("comapny_id");
		    JobListing jl=new JobListing(id, cid,description,location,jobType, salary,jobType, postdate);
		    list.add(jl);
		}
		DBUtility.dbClose();
		return list;
	}

	public List<JobListing> getJobListingsBySalaryRange(double minSalary, double maxSalary) throws SQLException {
		List<JobListing> jobListings = new ArrayList<>();
        Connection conn = DBUtility.getDBConn();
        String sql = "SELECT * FROM joblisting WHERE salary BETWEEN ? AND ?";
        PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, minSalary);
            ps.setDouble(2, maxSalary);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                JobListing job = new JobListing();
                
                jobListings.add(job);
            }
        DBUtility.dbClose();
        return jobListings;
	}

}
