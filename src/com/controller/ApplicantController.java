package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidEmailFormatting;
import com.model.Applicant;
import com.service.*;

public class ApplicantController {
	public static void main(String[] args) {
		ApplicantService as=new ApplicantService();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("***JOBLISTING OPERATION***");
			System.out.println("press 1. Create A Profile ");
			System.out.println("press 2. Apply for Job ");
			System.out.println("press 3. Get Applicant ");
			System.out.println("press 0. for exit");
			System.out.println("*************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				try {
				System.out.println("Enter the first Name");
				sc.nextLine();
				String firstName=sc.nextLine();
				
				System.out.println("Enter the last Name");
				String lastName=sc.next();
				System.out.println("Enter the email");
				sc.nextLine();
				String email=sc.nextLine();
				as.validateEmail(email);
				System.out.println("Enter the phone");
				String phone=sc.nextLine();
				
			
					as.createProfile(firstName,lastName,email,phone);
				} catch (SQLException | InvalidEmailFormatting e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());;
				}
				break;
				
			case 2:
				
				System.out.println("enter the Job Id");
				int id=sc.nextInt();
				System.out.println("enter the cover letter");
				String coverLetter=sc.nextLine();
				
				try {
					as.applyForJob(id,coverLetter);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 3:
				
				System.out.println("all applicants details");
				try {
					List<Applicant> list=as.getApplicants();
					for(Applicant a:list) {
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
