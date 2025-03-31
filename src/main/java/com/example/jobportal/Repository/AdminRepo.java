package com.example.jobportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jobportal.models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}