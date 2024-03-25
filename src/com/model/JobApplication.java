package com.model;

import java.time.LocalDate;

public class JobApplication {
	private int applicationId;
	private int jobId;
	private int applicantId;
	private LocalDate applicationDate;
	private String coverLetter;
	public JobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobApplication(int applicationId, int jobId, int applicantId, LocalDate applicationDate,
			String coverLetter) {
		super();
		this.applicationId = applicationId;
		this.jobId = jobId;
		this.applicantId = applicantId;
		this.applicationDate = applicationDate;
		this.coverLetter = coverLetter;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	@Override
	public String toString() {
		return "JobApplication [applicationId=" + applicationId + ", jobId=" + jobId + ", applicantId=" + applicantId
				+ ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";
	}
	
	

}
