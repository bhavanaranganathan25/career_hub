package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.service.*;
import com.exception.DatabaseConnectionException;
import com.model.JobApplication;
import com.service.JobListingService;

public class JobApplicationController {
	public static void main(String[] args) {
		JobApplicationService jobApplicationService = new JobApplicationService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Applicant ID:");
        int applicantId = scanner.nextInt();

        System.out.println("Enter Job ID:");
        int jobId = scanner.nextInt();

        System.out.println("Enter Cover Letter:");
        scanner.nextLine(); // Consume newline character
        String coverLetter = scanner.nextLine();

        try {
            jobApplicationService.applyForJob(applicantId, jobId, coverLetter);
            System.out.println("Job application submitted successfully!");
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println("Failed to submit job application: " + e.getMessage());
        }
    }

}
