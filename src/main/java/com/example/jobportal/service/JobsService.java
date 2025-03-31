package com.example.jobportal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.jobportal.Repository.JobsRepo;
import com.example.jobportal.models.Jobs;
@Service
public class JobsService {
    JobsRepo jobser;
    public JobsService(JobsRepo jobser)
    {
        this.jobser=jobser;
    }
    //get
    public List<Jobs> getJobs()
    {
        return jobser.findAll();
    }
    //get
    public Optional<Jobs> getJob(int id)
    {
        return jobser.findById(id);
    }
    //post
   public Jobs addJobs(Jobs postjobs) {
        return jobser.save(postjobs);
    }
    //put
    public Jobs updateJobs(int id,Jobs jobsUpdate)
    {
        Optional<Jobs> JobExcist=jobser.findById(id);
        if(JobExcist.isPresent())
        {
            Jobs updateJobsservice=JobExcist.get();
            updateJobsservice.setTitle(jobsUpdate.getTitle());
            updateJobsservice.setCompany(jobsUpdate.getCompany());
            updateJobsservice.setLocation(jobsUpdate.getLocation());
            updateJobsservice.setDescription(jobsUpdate.getDescription());
            updateJobsservice.setSalary(jobsUpdate.getSalary());
            return jobser.save(updateJobsservice);
        }
        else{
                return null;
        }
    }
    //delete
    public void delete(int id)
    {
        jobser.deleteById(id);
    }
    
    public Page<Jobs> getjobPage(int Page,int size, String sort) {
        PageRequest pagerequest=PageRequest.of(Page, size, Sort.by(sort));
        return jobser.findAll(pagerequest);
    }
    public List<Jobs> getJobsByTitle(String title) {
        return jobser.getJobsByTitle(title);
    }
    public void postJobs(Jobs jobs) {
        jobser.insertJobs(jobs.getTitle(), jobs.getCompany(), jobs.getLocation(), jobs.getDescription(), jobs.getSalary());
    }

}
