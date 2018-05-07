package com.example.freelancerbackend.repository;

import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.models.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface ProjectRepository extends CrudRepository<Projects, Long>{

   // Projects findByEmailAndPassword(String email, String password);
     //   Projects findByProject_id(int project_id);
    //Projects find(int project_id);
   Set<Projects> findByEmpUsernameNotAndStatus(String emp_username, String status);

   Set<Projects> findByEmpUsername(String emp_username);
  // Set<Projects> fin(String emp_username);

}
