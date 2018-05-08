package com.example.freelancerbackend.entity;
import javax.persistence.*;
import java.util.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
   private Long user_id;

    private String username;
    private String  email;
    private String  password;
    private  String  name;
    private  String  summary;
    private  String  phone;
    private String  about_me;
    private String  skills;
    private String  looking_for;



    @OneToMany(mappedBy = "userEntity", cascade=CascadeType.ALL)
    private Set<Bids> bids;

    public Set<Bids> getBids() {
        return bids;
    }

    public void setBids(Set<Bids> bids) {
        this.bids = bids;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLooking_for() {
        return looking_for;
    }

    public void setLooking_for(String looking_for) {
        this.looking_for = looking_for;
    }



    
}
