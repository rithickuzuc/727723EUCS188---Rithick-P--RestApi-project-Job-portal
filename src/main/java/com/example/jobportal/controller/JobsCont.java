package com.example.jobportal.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.models.Jobs;
import com.example.jobportal.service.JobsService;

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
public class JobsCont {
    JobsService Jobcon;
    public JobsCont(JobsService Jobcon) {
        this.Jobcon = Jobcon;
    }
    @GetMapping("/jobs/{id}")
    public Optional<Jobs> getJobs(@PathVariable int id)
    {
        return Jobcon.getJob(id);
    }
    @GetMapping("/jobs")
    public  List<Jobs> getJobss() {
            return Jobcon.getJobs();
      }
    @PostMapping("/jobs")
    public ResponseEntity<Jobs>postJobs(@RequestBody Jobs jobpos) {
        return new ResponseEntity<>( Jobcon.addJobs(jobpos),HttpStatus.CREATED);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<Jobs> upjobs(@PathVariable int id, @RequestBody Jobs jobupdate) {
       
        return  new ResponseEntity<>(Jobcon.updateJobs(id,jobupdate),HttpStatus.CREATED);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Object> deletejob(@PathVariable int id) {
        Jobcon.delete(id);
        return ResponseEntity.ok("Job is deleted successfully");
    }
    @GetMapping("/pagejobs")
    public ResponseEntity<Page<Jobs>> getJobs(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        Page<Jobs> jobs = Jobcon.getjobPage(page, size, sort);
        return ResponseEntity.ok(jobs);
    }
    @GetMapping("/title/{title}")
    public List<Jobs> getJobsByTitle(@PathVariable String title) {
        return Jobcon.getJobsByTitle(title);
    }

}
