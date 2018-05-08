package com.example.freelancerbackend.models;

public class Bids {

    private Long    id;
    private Long    user_id;
    private Long    project_id;
    private String  bid_price;
    private Long    days_req;
    private String  username;
    private String  name;
    private String projectTitle;


    private String projectID;
    private String projectEmployer;
    private Float projectAverageBid;
    private String projectStatus;

    public String getProjectID() {
        return projectID;
    }
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }


    public String getProjectEmployer() {
        return projectEmployer;
    }

    public void setProjectEmployer(String projectEmployer) {
        this.projectEmployer = projectEmployer;
    }

    public Float getProjectAverageBid() {
        return projectAverageBid;
    }

    public void setProjectAverageBid(Float projectAverageBid) {
        this.projectAverageBid = projectAverageBid;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public Long getProject_id() { return project_id; }
    public void setProject_id(Long project_id) { this.project_id = project_id; }

    public String getBid_price() { return bid_price; }
    public void setBid_price(String bid_price) { this.bid_price = bid_price; }

    public Long getDays_req() { return days_req; }
    public void setDays_req(Long days_req) { this.days_req = days_req; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
