// package com.example.jobportal.service;

// import com.example.jobportal.Repository.AdminRepo;
// import com.example.jobportal.models.Admin;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class AdminService {
//     private final AdminRepo adminRepo;

//     public AdminService(AdminRepo adminRepo) {
//         this.adminRepo = adminRepo;
//     }
    
//     public List<Admin> getAllAdmins() {
//         return adminRepo.findAll();
//     }

//     public Optional<Admin> getAdminById(int id) {
//         return adminRepo.findById(id);
//     }

//     public Admin createAdmin(Admin admin) {
//         return adminRepo.save(admin);
//     }

//     public Admin updateAdmin(int id, Admin adminDetails) {
//         return adminRepo.findById(id).map(admin -> {
//             admin.setName(adminDetails.getName());
//             admin.setEmail(adminDetails.getEmail());
//             admin.setCompany(adminDetails.getCompany());
//             return adminRepo.save(admin);
//         }).orElse(null);
//     }

//     public void deleteAdmin(int id) {
//         adminRepo.deleteById(id);
//     }
// }
package com.example.jobportal.service;

import com.example.jobportal.Repository.AdminRepo;
import com.example.jobportal.models.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public Optional<Admin> getAdminById(int id) {
        return adminRepo.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(int id, Admin adminDetails) {
        return adminRepo.findById(id).map(admin -> {
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            admin.setCompany(adminDetails.getCompany());
            return adminRepo.save(admin);
        }).orElse(null);
    }

    public void deleteAdmin(int id) {
        adminRepo.deleteById(id);
    }
}
