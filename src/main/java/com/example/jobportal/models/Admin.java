// package com.example.jobportal.models;

// import jakarta.persistence.*;

// @Entity
// public class Admin {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;
//     private String name;
//     private String email;

//     @OneToOne(cascade = CascadeType.ALL)  // Cascade ensures Company gets saved/updated/deleted with Admin
//     @JoinColumn(name = "id", referencedColumnName = "id")  // Owning side
//     private Company company;

//     public Admin() {}

//     public Admin(String name, String email, Company company) {
//         this.name = name;
//         this.email = email;
//         this.company = company;
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public Company getCompany() {
//         return company;
//     }

//     public void setCompany(Company company) {
//         this.company = company;
//     }
// }
//   
package com.example.jobportal.models;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    private int id; // Manually assigned ID instead of auto-generated
    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")  // Uses the same ID as Company
    private Company company;

    public Admin() {}

    public Admin(int id, String name, String email, Company company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
