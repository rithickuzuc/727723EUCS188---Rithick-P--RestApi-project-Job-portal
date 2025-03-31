package com.example.jobportal.service;

import com.example.jobportal.models.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final com.example.jobportal.Repository.CompanyRepo companyRepo;

    public CompanyService(com.example.jobportal.Repository.CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Optional<Company> getCompanyById(int id) {
        return companyRepo.findById(id);
    }

    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    public Company updateCompany(int id, Company companyDetails) {
        return companyRepo.findById(id).map(company -> {
            company.setName(companyDetails.getName());
            company.setLocation(companyDetails.getLocation());
            company.setIndustryType(companyDetails.getIndustryType());
            company.setDescription(companyDetails.getDescription());
            company.setUpdatedAt(companyDetails.getUpdatedAt());
            return companyRepo.save(company);
        }).orElse(null);
    }

    public void deleteCompany(int id) {
        companyRepo.deleteById(id);
    }
}