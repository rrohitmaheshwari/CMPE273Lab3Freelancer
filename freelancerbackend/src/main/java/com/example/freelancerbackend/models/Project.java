package com.example.freelancerbackend.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

public class Project {

    private Long 	project_id;

    @Column(name = "emp_username")
    private String  empUsername;
    private String  title;
    private String  description;
    private String  budget_range;
    private String  skills_req;
    private String  status;
    private String  complete_by;
    private String  filenames;
    private String  freelancer_username;
    private String  message;
    private Integer bid_count;

    public Long getProject_id() { return project_id; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setProject_id(Long project_id) { this.project_id = project_id; }



    public String getTitle() { return title; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setDescription(String description) { this.description = description; }

    public String getBudget_range() { return budget_range; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setBudget_range(String budget_range) { this.budget_range = budget_range; }

    public String getSkills_req() { return skills_req; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setSkills_req(String skills_req) { this.skills_req = skills_req; }

    public String getStatus() { return status; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setStatus(String status) { this.status = status; }

    public String getComplete_by() { return complete_by; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setComplete_by(String complete_by) { this.complete_by = complete_by; }

    public String getFilenames() { return filenames; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setFilenames(String filenames) { this.filenames = filenames; }

    public String getFreelancer_username() { return freelancer_username; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setFreelancer_username(String freelancer_username) { this.freelancer_username = freelancer_username; }

    public String getMessage() { return message; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setMessage(String message) { this.message = message; }

    public Integer getBid_count() { return bid_count; }
    @JsonInclude(JsonInclude.Include.NON_EMPTY) public void setBid_count(Integer bid_count) { this.bid_count = bid_count; }


    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }


}
