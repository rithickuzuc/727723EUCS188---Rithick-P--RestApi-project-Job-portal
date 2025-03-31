// package com.example.jobportal.models;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// @Entity
// public class Jobs {
//     @Id
//     private int id;
//     private String title;
//     private String company;
//     private String location;
//     private String description;
//     private int salary;
//     public int getId() {
//         return id;
//     }
//     public Jobs(int id, String company, String location, String description, int salary) {
//         this.id = id;
        
//         this.company = company;
//         this.location = location;
//         this.description = description;
//         this.salary = salary;
//     }
//     public Jobs(String title) {
//         this.title = title;
//     }
//     public void setId(int id) {
//         this.id = id;
//     }
//     public String getCompany() {
//         return company;
//     }
//     public void setCompany(String company) {
//         this.company = company;
//     }
//     public String getLocation() {
//         return location;
//     }
//     public void setLocation(String location) {
//         this.location = location;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }
//     public int getSalary() {
//         return salary;
//     }
//     public void setSalary(int salary) {
//         this.salary = salary;
//     }
//     public Jobs()
//     {
        
//     }
//     public String getTitle() {
//         return title;
//     }
//     public void setTitle(String title) {
//         this.title = title;
//     }
    
    
// }
package com.example.jobportal.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Jobs {
    @Id
    private int id;  // Manually entered ID (Removed @GeneratedValue)
    
    private String title;
    private String company;
    private String location;
    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private double salary;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Jobseekers> jobseekers;

    public Jobs() {}

    public Jobs(int id, String title, String company, String location, double salary) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public List<Jobseekers> getJobseekers() { return jobseekers; }
    public void setJobseekers(List<Jobseekers> jobseekers) { this.jobseekers = jobseekers; }
}
