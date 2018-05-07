package com.example.freelancerbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

import static javax.persistence.CascadeType.ALL;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "projects")
public class Projects {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 	project_id;
    @Column(name = "emp_username")
    private String  empUsername;
    private String  title;
    private String  description;
    private String  budget_range;
    @Column(length = 1000)
    private String  skills_req;
    private String  status;
    private String  complete_by;
    @Column(length = 1000)
    private String  filenames;
    private String  freelancer_username;

    @OneToMany(mappedBy = "projectEntity", cascade=CascadeType.ALL)
    private Set<Bids> bids;

    public Projects() {};

    public Projects(String empUsername, String title, String description, String budget_range, String skills_req, String status, String complete_by, String filenames) {
        this.empUsername = empUsername;
        this.title = title;
        this.description = description;
        this.budget_range = budget_range;
        this.skills_req = skills_req;
        this.status = status;
        this.complete_by = complete_by;
        this.filenames = filenames;
    }

    public Long getProject_id() { return project_id; }
    public void setProject_id(Long project_id) { this.project_id = project_id; }

    public String getEmpUsername() {return empUsername; }
    public void setEmpUsername(String empUsername) { this.empUsername = empUsername; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBudget_range() { return budget_range; }
    public void setBudget_range(String budget_range) { this.budget_range = budget_range; }

    public String getSkills_req() { return skills_req; }
    public void setSkills_req(String skills_req) { this.skills_req = skills_req; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getComplete_by() { return complete_by; }
    public void setComplete_by(String complete_by) { this.complete_by = complete_by; }

    public String getFilenames() { return filenames; }
    public void setFilenames(String filenames) { this.filenames = filenames; }

    public String getFreelancer_username() { return freelancer_username; }
    public void setFreelancer_username(String freelancer_username) { this.freelancer_username = freelancer_username; }

    public Set<Bids> getBids() { return bids; }
    public void setBids(Set<Bids> bids) { this.bids = bids; }
}
