package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Applicant;
import com.model.*;
import com.service.*;

public class CompanyController {
	public static void main(String[] args) {
	CompanyService companylist=new CompanyService();
	Scanner sc=new Scanner(System.in);
	while (true) {
		System.out.println("***JOBLISTING OPERATION***");
		System.out.println("press 1. Post a Job ");
		System.out.println("press 2. Get Job ");
		System.out.println("press 3. Get Company");
		System.out.println("press 0. for exit");
		System.out.println("*************");
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("Exiting...Thank you!!!");
			break;
		}
		switch (input) {
		case 1:
			System.out.println("Enter the job Description");
			String des=sc.nextLine();
			System.out.println("Enter the location");
			String loc=sc.next();
			System.out.println("Enter the Salary");
			double salary=sc.nextDouble();
			System.out.println("Enter the job Type");
			String type=sc.nextLine();
			
			try {
				companylist.postJob(des,loc,salary,type);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("Get a Job");
			List<JobListing> list;
			try {
				list = companylist.getJobs();
			for(JobListing a:list) {
				System.out.println(a);
			}
		}
			catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
			break;
			
		case 3:
			System.out.println("all Company details");
			try {
				List<Company> list1=companylist.getCompany();
				for(Company a:list1) {
					System.out.println(a);
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
			
			

			
	}
}
}
