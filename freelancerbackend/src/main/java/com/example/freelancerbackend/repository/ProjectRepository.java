package com.example.freelancerbackend.repository;

import com.example.freelancerbackend.entity.Projects;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Projects, Long>{

    Projects findByEmailAndPassword(String email, String password);
        Projects findByProject_id(int project_id);
    Projects find(int project_id);
}
