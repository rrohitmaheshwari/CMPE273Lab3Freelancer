package com.example.freelancerbackend.repository;

import com.example.freelancerbackend.entity.Users;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long>{

    Users findByEmailAndPassword(String email,String password);
}
