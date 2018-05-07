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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long project_id;
    private String emp_username;
    private String title;
    private String description;
    private String budget_range;
    private String skills_req;
    private String status;
    private String complete_by;
    private String filenames;
    private String freelancer_username;




    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getEmp_username() {
        return emp_username;
    }

    public void setEmp_username(String emp_username) {
        this.emp_username = emp_username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudget_range() {
        return budget_range;
    }

    public void setBudget_range(String budget_range) {
        this.budget_range = budget_range;
    }

    public String getSkills_req() {
        return skills_req;
    }

    public void setSkills_req(String skills_req) {
        this.skills_req = skills_req;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplete_by() {
        return complete_by;
    }

    public void setComplete_by(String complete_by) {
        this.complete_by = complete_by;
    }

    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    public String getFreelancer_username() {
        return freelancer_username;
    }

    public void setFreelancer_username(String freelancer_username) {
        this.freelancer_username = freelancer_username;
    }
}
