package com.example.jobportal.service;

import com.example.jobportal.Repository.JobApplicationRepository;
import com.example.jobportal.enums.ApplicationStatus;
import com.example.jobportal.models.JobApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return jobApplicationRepository.findById(id);
    }

    public JobApplication submitApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplication updateApplicationStatus(Long id, ApplicationStatus status) {
        Optional<JobApplication> optionalApplication = jobApplicationRepository.findById(id);
        if (optionalApplication.isPresent()) {
            JobApplication application = optionalApplication.get();
            application.setStatus(status);
            return jobApplicationRepository.save(application);
        }
        return null;
    }

    public void deleteApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}