package com.example.freelancerbackend.service;

import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.entity.UserProjects;
import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.models.HomeDetails;
import com.example.freelancerbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public Users login(Users testuser){

        System.out.println(" PAss-");
        System.out.println(testuser.getPassword());


        System.out.println(" getUsername&PASs-");
        System.out.println(userRepository.findByUsernameAndPassword(testuser.getUsername(),testuser.getPassword()).getName());



        return userRepository.findByUsernameAndPassword(testuser.getUsername(),testuser.getPassword());
    }


    public Users getUser(Users testuser){



        System.out.println(" getUsername&PASs-");
        System.out.println(userRepository.findByUsername(testuser.getUsername()).getName());



        return userRepository.findByUsername(testuser.getUsername());
    }

    public   List<Projects>  getHomeDetails(String testuser){


       // System.out.println(userRepository.getHomeDetails(testuser));


       // List<HomeDetails> temp = (List<HomeDetails>)userRepository.getHomeDetails(testuser,"open");
        List<Projects> ob1= userRepository.getHomeDetails(testuser,"open");
        List<UserProjects> ob2= userRepository.getHomeDetailsBid(testuser,"open");




        return ob1;
    }

}