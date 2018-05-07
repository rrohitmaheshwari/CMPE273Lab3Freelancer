package com.example.freelancerbackend.models;

public class HomeDetails {

    private String project_id;
    private String emp_username;
    private String title;
    private String description;
    private String budget_range;
    private String skills_req;
    private String status;
    private String niceDate;
    private String user_projects_project_id;
    private String bid_count;

    public HomeDetails(String project_id, String emp_username, String title, String description, String budget_range, String skills_req, String status, String niceDate, String user_projects_project_id, String bid_count) {
        this.project_id = project_id;
        this.emp_username = emp_username;
        this.title = title;
        this.description = description;
        this.budget_range = budget_range;
        this.skills_req = skills_req;
        this.status = status;
        this.niceDate = niceDate;
        this.user_projects_project_id = user_projects_project_id;
        this.bid_count = bid_count;
    }



    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
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

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getUser_projects_project_id() {
        return user_projects_project_id;
    }

    public void setUser_projects_project_id(String user_projects_project_id) {
        this.user_projects_project_id = user_projects_project_id;
    }

    public String getBid_count() {
        return bid_count;
    }

    public void setBid_count(String bid_count) {
        this.bid_count = bid_count;
    }



}
