package com.example.freelancerbackend.repository;

import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.entity.UserProjects;
import com.example.freelancerbackend.models.HomeDetails;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByUsernameAndPassword(String username,String password);
    Users findByUsername(String username);



 @Query("SELECT p.project_id ,p.emp_username,p.title,p.description,p.budget_range,p.skills_req, p.status,p.complete_by as niceDate,p.project_id as user_projects_project_id  from  Projects p Where status=:open AND emp_username<>:username")
 List<Projects> getHomeDetails(@Param("username") String username,@Param("open") String open);

    @Query("SELECT id,user_id,project_id ,bid_price,days_req from  UserProjects ")
    List<UserProjects> getHomeDetailsBid(@Param("username") String username,@Param("open") String open);



}
