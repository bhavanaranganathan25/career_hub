package com.controller;

import com.exception.DatabaseConnectionException;
import com.model.*;
import com.service.JobListingService;

import java.sql.SQLException;
import java.util.*;
public class JobListingController {
	public static void main(String[] args)  {
		JobListingService joblist=new JobListingService();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("***JOBLISTING OPERATION***");
			System.out.println("press 1. Apply for job ");
			System.out.println("press 2. Get Applicants ");
			System.out.println("press 3. Get Job Listing ");
			System.out.println("press 4. Salary Range");
			System.out.println("press 0. for exit");
			System.out.println("*************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("Enter the Applicant id");
				int id=sc.nextInt();
				System.out.println("Enter the cover Letter");
				String coverLetter=sc.nextLine();
				
				try {
					joblist.apply(id,coverLetter);
				} catch (SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				System.out.println("all applicants details");
				try {
					List<Applicant> list=joblist.getApplicant();
					for(Applicant a:list) {
						System.out.println(a);
					}
				}catch(SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
				break;
	
			
			case 3:
				
				System.out.println("all Job Listing details");
				try {
					List<JobListing> list=joblist.getJobListings();
					for(JobListing a:list) {
						System.out.println(a);
					}
				}catch(SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				System.out.print("Enter minimum salary: ");
		        double minSalary = sc.nextDouble();
		        System.out.print("Enter maximum salary: ");
		        double maxSalary = sc.nextDouble();
		        try {
		            List<JobListing> jobListings = joblist.getJobListingsBySalaryRange(minSalary, maxSalary);
		            
		            for (JobListing job : jobListings) {
		                System.out.println(job);		            }
		        } catch (SQLException | DatabaseConnectionException e) {
		            System.out.println("An error occurred while retrieving job listings: " + e.getMessage());
		        }
		        
				
			}
				
				
			}
}
}