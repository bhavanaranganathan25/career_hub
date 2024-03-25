package com.service;
import java.sql.SQLException;
import com.exception.*;
import java.util.List;

import com.dao.*;
import com.model.Applicant;
public class ApplicantService {
	ApplicantDaoImpl applicantimpl=new ApplicantDaoImpl();
	public void createProfile(String firstName, String lastName, String email, String phone) throws SQLException, DatabaseConnectionException {
		applicantimpl.createProfile(firstName,lastName, email,phone);
		
			
		
	}
	public void applyForJob(int id, String coverLetter) throws SQLException, DatabaseConnectionException {
		applicantimpl.applyForJob(id,coverLetter);
		
	}
	public List<Applicant> getApplicants() throws SQLException, DatabaseConnectionException {
		
		return applicantimpl.getApplicant();
	}
	public void validateEmail(String email) throws InvalidEmailFormatting {
		 if (email.endsWith("@gmail.com")) {
	            return;
	        } else {
	            throw new InvalidEmailFormatting("email is invalid");
	        }
	    }
	public void validateResume(String resume) throws FileUploadException {
		if(resume.endsWith(".pdf")) {
			return;
		}
	else {
		throw new FileUploadException("not supporting file");
		
	}
		
	}
}

