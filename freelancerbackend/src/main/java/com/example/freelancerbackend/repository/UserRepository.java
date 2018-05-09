package com.example.freelancerbackend.repository;
import com.example.freelancerbackend.entity.Users;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Users, Long> {


    Users findByEmailAndPassword(String email,String password);

    Users findByUsernameAndPassword(String username,String password);

    Users findByUsername(String username);

    Users findByEmail(String email);



}
