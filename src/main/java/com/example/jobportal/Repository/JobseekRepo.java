package com.example.jobportal.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.jobportal.models.Jobseekers;

import jakarta.transaction.Transactional;


@Repository
public interface JobseekRepo extends JpaRepository<Jobseekers,Integer> {
    List<Jobseekers> findByJobId(int jobId);
    @Query("SELECT j FROM Jobseekers j")
    public List<Jobseekers> getJobseekers(); 
    @Query("SELECT j FROM Jobseekers j WHERE j.phoneNumber = :phoneNumber")
    public List<Jobseekers> getJobseekersPhoneNumber(String phoneNumber);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Jobseekers (name, email, phoneNumber, resumeUrl, skills) VALUES (:name, :email, :phoneNumber, :resumeUrl, :skills)", nativeQuery = true)
   void insertJobseeker(@Param("name") String name, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("resumeUrl") String resumeUrl, @Param("skills") List<String> skills);
}
