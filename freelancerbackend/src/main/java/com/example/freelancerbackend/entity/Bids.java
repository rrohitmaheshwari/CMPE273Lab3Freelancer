package com.example.freelancerbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "user_projects")
@Cacheable(false)
public class Bids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    private String  bid_price;
    private Long     days_req;

    @ManyToOne(fetch=FetchType.EAGER)

    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Projects projectEntity;



    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userEntity;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBid_price() { return bid_price; }
    public void setBid_price(String bid_price) { this.bid_price = bid_price; }

    public Long getDays_req() { return days_req; }
    public void setDays_req(Long days_req) { this.days_req = days_req; }

    public Projects getProjectEntity() { return projectEntity; }
    public void setProjectEntity(Projects projectEntity) { this.projectEntity = projectEntity; }

    public Users getUserEntity() { return userEntity; }
    public void setUserEntity(Users userEntity) { this.userEntity = userEntity; }
}
