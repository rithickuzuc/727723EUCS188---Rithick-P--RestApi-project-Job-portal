// package com.example.jobportal.models;

// import jakarta.persistence.*;

// @Entity
// public class Company {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;
//     private String name;
//     private String location;
//     private String industryType;
//     private String description;
//     private String createdAt;
//     private String updatedAt;

//     @OneToOne(mappedBy = "company")  // Inverse side of One-to-One relation
//     private Admin admin;

//     public Company() {}

//     public Company(String name, String location, String industryType, String description, String createdAt, String updatedAt) {
//         this.name = name;
//         this.location = location;
//         this.industryType = industryType;
//         this.description = description;
//         this.createdAt = createdAt;
//         this.updatedAt = updatedAt;
//     }

//     public long getId() {
//         return id;
//     }

//     public void setId(long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getLocation() {
//         return location;
//     }

//     public void setLocation(String location) {
//         this.location = location;
//     }

//     public String getIndustryType() {
//         return industryType;
//     }

//     public void setIndustryType(String industryType) {
//         this.industryType = industryType;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getCreatedAt() {
//         return createdAt;
//     }

//     public void setCreatedAt(String createdAt) {
//         this.createdAt = createdAt;
//     }

//     public String getUpdatedAt() {
//         return updatedAt;
//     }

//     public void setUpdatedAt(String updatedAt) {
//         this.updatedAt = updatedAt;
//     }
// }
package com.example.jobportal.models;

import jakarta.persistence.*;

@Entity
public class Company {
    @Id
    private int id; // Manually assigned ID instead of auto-generated
    private String name;
    private String location;
    private String industryType;
    private String description;
    private String createdAt;
    private String updatedAt;

    @OneToOne(mappedBy = "company")
    private Admin admin;

    public Company() {}

    public Company(int id, String name, String location, String industryType, String description, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.industryType = industryType;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
