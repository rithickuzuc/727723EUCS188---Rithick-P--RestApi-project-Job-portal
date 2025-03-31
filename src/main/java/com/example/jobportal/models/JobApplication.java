package com.example.jobportal.models;

import com.example.jobportal.enums.ApplicationStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    private Long id;

    private String applicantName;
    private String email;
    private String resumeUrl;
    private LocalDate appliedDate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    public JobApplication() {
        this.appliedDate = LocalDate.now();
        this.status = ApplicationStatus.PENDING; // Default status
    }

    public JobApplication(String applicantName, String email, String resumeUrl) {
        this.applicantName = applicantName;
        this.email = email;
        this.resumeUrl = resumeUrl;
        this.appliedDate = LocalDate.now();
        this.status = ApplicationStatus.PENDING;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }

    public LocalDate getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }
}