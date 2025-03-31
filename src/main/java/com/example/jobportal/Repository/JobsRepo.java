package com.example.jobportal.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jobportal.models.Jobs;
@Repository
public interface JobsRepo extends JpaRepository<Jobs,Integer> { 
    //JPQL
    @Query("SELECT j FROM Jobs j")
    public List<Jobs> getJobs();
    @Query("SELECT j FROM Jobs j WHERE j.title = :title")
    public List<Jobs> getJobsByTitle(String title);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Jobs (title, company, location, description, salary) VALUES (:title, :company, :location, :description, :salary)", nativeQuery = true)
    void insertJobs(@Param("title") String title, @Param("company") String company, @Param("location") String location, @Param("description") String description, @Param("salary") double salary);

}
