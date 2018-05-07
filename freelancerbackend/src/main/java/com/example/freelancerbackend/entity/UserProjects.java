package com.example.freelancerbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user_projects")
public class UserProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user_id;
    private String project_id;
    private String bid_price;
    private int days_req;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getBid_price() {
        return bid_price;
    }

    public void setBid_price(String bid_price) {
        this.bid_price = bid_price;
    }

    public int getDays_req() {
        return days_req;
    }

    public void setDays_req(int days_req) {
        this.days_req = days_req;
    }
}
