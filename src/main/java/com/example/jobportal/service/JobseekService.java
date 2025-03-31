// package com.example.jobportal.service;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;
// import com.example.jobportal.Repository.JobseekRepo;
// import com.example.jobportal.models.Jobseekers;
// @Service
// public class JobseekService {
//     JobseekRepo jobseeks;
//     public JobseekService(JobseekRepo jobseeks) {
//         this.jobseeks = jobseeks;
//     }
//     //get
//     public List<Jobseekers> getJobseeker() {
//         return jobseeks.findAll();
//     }
//     //get
//     public Optional<Jobseekers> getJobseekid(int id)
//     {
//         return jobseeks.findById(id);
//     }
//     //post
//     public Jobseekers addJobseeker(Jobseekers jobseekeradd) {
//         return jobseeks.save(jobseekeradd);
//     }
//     //put
//     public Jobseekers updateJobseeker(int id,Jobseekers jobseekerupdate) {
//         Optional <Jobseekers> JobseekerExcits=jobseeks.findById(id);
//         if(JobseekerExcits.isPresent()) 
//         {
//             Jobseekers updateJobseekers=JobseekerExcits.get();
//             updateJobseekers.setName(jobseekerupdate.getName());
//             updateJobseekers.setEmail(jobseekerupdate.getEmail());
//             updateJobseekers.setPhoneNumber(jobseekerupdate.getPhoneNumber());
//             updateJobseekers.setResumeUrl(jobseekerupdate.getResumeUrl());
//             updateJobseekers.setSkills(jobseekerupdate.getSkills());
//             return jobseeks.save(updateJobseekers);

//         }
//         else{
//                return null;
//         }
//     }
//     //delete
//     public void delete(int id)
//     {
//         jobseeks.deleteById(id);
//     }
//     public Page<Jobseekers> getseekPage(int Page,int size, String sort) {
//         PageRequest pagerequest=PageRequest.of(Page, size, Sort.by(sort));
//         return jobseeks.findAll(pagerequest);
//     }
//     public List<Jobseekers>getJobseekersPhoneNumber(String phoneNumber) {
//         return jobseeks.getJobseekersPhoneNumber(phoneNumber);
//     }
//    public void postjobseeker(Jobseekers jobseeker) {
//      jobseeks.insertJobseeker(jobseeker.getName(), jobseeker.getEmail(), jobseeker.getPhoneNumber(), jobseeker.getResumeUrl(), jobseeker.getSkills());

//    }

// }
package com.example.jobportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.jobportal.Repository.JobseekRepo;
import com.example.jobportal.models.Jobs;
import com.example.jobportal.models.Jobseekers;
import com.example.jobportal.Repository.JobsRepo;

@Service
public class JobseekService {
    @Autowired
    private final JobseekRepo jobseeks;
    @Autowired
    private final JobsRepo jobRepo;
    public JobseekService() {
        this.jobseeks = null;
        this.jobRepo = null;
    }
   
    public JobseekService(JobseekRepo jobseeks) {
        this.jobseeks = jobseeks;
        this.jobRepo = null;
    }
    public JobseekService(JobsRepo jobRepo) {
        this.jobseeks = null;
        this.jobRepo = jobRepo;
    }
   
    // GET all job seekers
    public List<Jobseekers> getJobseeker() {
        return jobseeks.findAll();
    }

    // GET job seeker by ID
    public Optional<Jobseekers> getJobseekid(int id) {
        return jobseeks.findById(id);
    }

    // POST: Add a new job seeker with a manual ID
    public Jobseekers addJobseeker(Jobseekers jobseekeradd) {
        if (jobseeks.existsById(jobseekeradd.getId())) {
            throw new RuntimeException("Jobseeker ID already exists! Choose a unique ID.");
        }
        return jobseeks.save(jobseekeradd);
    }

    // PUT: Update an existing job seeker
    public Jobseekers updateJobseeker(int id, Jobseekers jobseekerupdate) {
        Optional<Jobseekers> jobseekerExists = jobseeks.findById(id);
        if (jobseekerExists.isPresent()) {
            Jobseekers updateJobseekers = jobseekerExists.get();
            updateJobseekers.setName(jobseekerupdate.getName());
            updateJobseekers.setEmail(jobseekerupdate.getEmail());
            updateJobseekers.setPhoneNumber(jobseekerupdate.getPhoneNumber());
            updateJobseekers.setResumeUrl(jobseekerupdate.getResumeUrl());
            updateJobseekers.setSkills(jobseekerupdate.getSkills());
            return jobseeks.save(updateJobseekers);
        } else {
            throw new RuntimeException("Jobseeker not found!");
        }
    }

    // DELETE job seeker by ID
    public void delete(int id) {
        if (jobseeks.existsById(id)) {
            jobseeks.deleteById(id);
        } else {
            throw new RuntimeException("Jobseeker not found!");
        }
    }

    // GET paginated job seekers
    public Page<Jobseekers> getseekPage(int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
        return jobseeks.findAll(pageRequest);
    }

    // GET job seekers by phone number
    public List<Jobseekers> getJobseekersPhoneNumber(String phoneNumber) {
        return jobseeks.getJobseekersPhoneNumber(phoneNumber);
    }

    // POST job seeker with manual ID insertion
    public void postjobseeker(Jobseekers jobseeker) {
        if (jobseeks.existsById(jobseeker.getId())) {
            throw new RuntimeException("Jobseeker ID already exists! Choose a different ID.");
        }
        jobseeks.save(jobseeker);  // This will insert the job seeker with the manual ID
    }
    public Jobseekers addJobseeker(Jobseekers jobseeker, int jobId) {
        Optional<Jobs> jobOpt = jobRepo.findById(jobId);
        if (jobOpt.isPresent()) {
            jobseeker.setJob(jobOpt.get()); // Assigning job
            return jobseeks.save(jobseeker);
        } else {
            throw new RuntimeException("Job ID not found!");
        }
    }
    


public List<Jobseekers> getJobseekersByJobId(int jobId) {
    return jobseeks.findByJobId(jobId);
}

}
