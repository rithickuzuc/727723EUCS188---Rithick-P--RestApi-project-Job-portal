package com.example.jobportal.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.jobportal.models.Jobseekers;
import com.example.jobportal.service.JobseekService;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class JobseekerCont {
    JobseekService jobseekcont;
    public JobseekerCont(JobseekService jobseekcont) {
        this.jobseekcont = jobseekcont;
    }
    @GetMapping("/jobseekers")
    public List<Jobseekers> getJobseekers() {
        return jobseekcont.getJobseeker();
    }
    @GetMapping("/jobseekers/{id}")
    public Optional<Jobseekers> getjobseeker(int id)
    {
        return jobseekcont.getJobseekid(id);
    }
    @PostMapping("/jobseekers")
    public ResponseEntity<Jobseekers> postjobseeker(@RequestBody Jobseekers Jobseekpos) {
  
        return  new ResponseEntity<>(jobseekcont.addJobseeker(Jobseekpos),HttpStatus.CREATED);
    }
    @PutMapping("jobseekers/{id}")
    public ResponseEntity<Jobseekers> updatejobseeker(@PathVariable int id, @RequestBody Jobseekers Jobseekerdt) {
       
        return new ResponseEntity<>(jobseekcont.updateJobseeker(id, Jobseekerdt),HttpStatus.CREATED);
        
    }
    @DeleteMapping("/jobseekers/{id}")
    public ResponseEntity<Object> deletejobseeker(@PathVariable int id) {
        jobseekcont.delete(id);
        return ResponseEntity.ok("Jobseeker deleted successfully");
    }
    @GetMapping("/pagejobseeker")
    public ResponseEntity<Page<Jobseekers>> getPage(@RequestParam int Page,@RequestParam int size,@RequestParam String sort) {
        Page<Jobseekers> page=jobseekcont.getseekPage(Page, size, sort);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/phonenumber/{phoneNumber}")
    public List<Jobseekers> getJobseekersPhoneNumber(@PathVariable String phoneNumber) {
        return jobseekcont.getJobseekersPhoneNumber(phoneNumber);
    }
    @PostMapping("/jobseekers/{jobId}")
    public ResponseEntity<Jobseekers> postJobseeker(@RequestBody Jobseekers jobseeker, @PathVariable int jobId) {
        return new ResponseEntity<>(jobseekcont.addJobseeker(jobseeker, jobId), HttpStatus.CREATED);
    }
    
    @GetMapping("/jobseekers/job/{jobId}")
    public List<Jobseekers> getJobseekersByJobId(@PathVariable int jobId) {
        return jobseekcont.getJobseekersByJobId(jobId);
    }
    
    
}
