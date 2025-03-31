// package com.example.jobportal.models;
// import java.util.List;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// @Entity
// public class Jobseekers {
//         @Id
//          private int id;
//          private String name;
//          private String email;
//          private String phoneNumber;
//          private String resumeUrl;
//          private List<String> skills;
//         public int getId() {
//             return id;
//         }
//         public void setId(int id) {
//             this.id = id;
//         }
//         public String getName() {
//             return name;
//         }
//         public void setName(String name) {
//             this.name = name;
//         }
//         public Jobseekers(int id, String name, String email, String phoneNumber, String resumeUrl,
//                 List<String> skills) {
//             this.id = id;
//             this.name = name;
//             this.email = email;
//             this.phoneNumber = phoneNumber;
//             this.resumeUrl = resumeUrl;
//             this.skills = skills;
//         }
//         public String getEmail() {
//             return email;
//         }
//         public void setEmail(String email) {
//             this.email = email;
//         }
//         public String getPhoneNumber() {
//             return phoneNumber;
//         }
//         public void setPhoneNumber(String phoneNumber) {
//             this.phoneNumber = phoneNumber;
//         }
//         public String getResumeUrl() {
//             return resumeUrl;
//         }
//         public void setResumeUrl(String resumeUrl) {
//             this.resumeUrl = resumeUrl;
//         }
//         public List<String> getSkills() {
//             return skills;
//         }
//         public void setSkills(List<String> skills) {
//             this.skills = skills;
//         }
         
//         public Jobseekers()
//         {
            
//         }
// }
package com.example.jobportal.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Jobseekers {
    @Id
    private int id; // Manually entered ID (Removed @GeneratedValue)
    
    private String name;
    private String email;
    private String phoneNumber;
    private String resumeUrl;

    @ElementCollection
    private List<String> skills;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @JsonBackReference
    private Jobs job;

    public Jobseekers() {}

    public Jobseekers(int id, String name, String email, String phoneNumber, String resumeUrl, List<String> skills, Jobs job) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.resumeUrl = resumeUrl;
        this.skills = skills;
        this.job = job;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public Jobs getJob() { return job; }
    public void setJob(Jobs job) { this.job = job; }
}
