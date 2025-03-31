package com.example.jobportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jobportal.models.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    Company findByName(String name);
}
