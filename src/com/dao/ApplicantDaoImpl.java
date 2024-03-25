package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Applicant;
import com.util.DBUtility;

public class ApplicantDaoImpl {

	public void createProfile(String firstName, String lastName, String email, String phone) throws SQLException, DatabaseConnectionException {
		Connection conn=DBUtility.getDbConn();
		String sql="insert into applicant( firstName, lastName, email,phone) values(?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, email);
		ps.setString(4, phone);
		int rst=ps.executeUpdate();
		
			
		DBUtility.DBClose();
		
	}

	public void applyForJob(int id, String coverLetter) throws SQLException, DatabaseConnectionException {
		Connection conn=DBUtility.getDbConn();
		String sql="insert into jobapllication(joblisting_id, cover_letter) values (?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		ps.setString(2, coverLetter);
		int rst=ps.executeUpdate();
		
		
		DBUtility.DBClose();
	}

	public List<Applicant> getApplicant() throws SQLException, DatabaseConnectionException {
		List<Applicant> list=new ArrayList<>();
		Connection conn=DBUtility.getDbConn();
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
		DBUtility.DBClose();
		return list;
	}

}
