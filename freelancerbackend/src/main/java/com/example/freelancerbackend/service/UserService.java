package com.example.freelancerbackend.service;

import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public Users login(Users testuser){

        System.out.println(" PAss-");
        System.out.println(testuser.getPassword());


        System.out.println(" findByEmail&PASs-");
        System.out.println(userRepository.findByEmailAndPassword(testuser.getEmail(),testuser.getPassword()).getName());



        return userRepository.findByEmailAndPassword(testuser.getEmail(),testuser.getPassword());
    }
}