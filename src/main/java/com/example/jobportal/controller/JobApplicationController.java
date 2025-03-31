package com.example.jobportal.controller;

import com.example.jobportal.enums.ApplicationStatus;
import com.example.jobportal.models.JobApplication;
import com.example.jobportal.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Optional<JobApplication> getApplicationById(@PathVariable Long id) {
        return jobApplicationService.getApplicationById(id);
    }

    @PostMapping
    public JobApplication submitApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.submitApplication(jobApplication);
    }

    @PutMapping("/{id}/status")
    public JobApplication updateApplicationStatus(@PathVariable Long id, @RequestParam ApplicationStatus status) {
        return jobApplicationService.updateApplicationStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        jobApplicationService.deleteApplication(id);
    }
}