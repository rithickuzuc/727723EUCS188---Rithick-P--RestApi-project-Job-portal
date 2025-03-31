package com.example.jobportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.models.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    
} 