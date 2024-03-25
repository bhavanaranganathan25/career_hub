package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

import com.model.Applicant;
import com.model.Company;
import com.model.JobListing;
import com.util.DBUtility;

public class CompanyDaoImpl {

	public void postJob(String des, String loc, double salary, String type) throws SQLException {
		Connection conn=DBUtility.getDBConn();
		String sql="insert into(company_id,job_title,job_description,job_location,salary,job_type,posted_date)values(?,?,?,?,?,?,?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, loc);
		
		ResultSet rst=ps.executeQuery();
		if(rst.next()) {
			int cid=rst.getInt("company_id");
			String title=rst.getString("job_title");
			String description=rst.getString("job_description");
			String location =rst.getString("location");
			Double salary1=rst.getDouble("salary");
			String jobType=rst.getString("job_type");
			LocalDate postdate=rst.getDate("posted_date").toLocalDate();
			
		}
		DBUtility.dbClose();
		
	}

	public List<JobListing> getJobs() throws SQLException {
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

	public List<Company> getCompany() throws SQLException {
		List<Company> list = new ArrayList<>();
		Connection conn=DBUtility.getDBConn();
		String sql="select * from customer";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rst=ps.executeQuery();
		while(rst.next()) {
			int id=rst.getInt("id");
			String name=rst.getString("name");
			String loc=rst.getString("location");
		    Company c=new Company();
		    list.add(c);
		}
		DBUtility.dbClose();
		return list;
	}
}



