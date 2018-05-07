package com.example.freelancerbackend.service;

import com.example.freelancerbackend.converters.Convertors;
import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.helpers.Converter;
import com.example.freelancerbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Projects postFreelancer(Projects project){

        Optional<Projects> projectOpt = projectRepository.findById(project.getProject_id());

        if ( !projectOpt.isPresent()) {
            return null;
        }

        Projects projectToUpdate = projectOpt.get();
        projectToUpdate.setStatus("Assigned");
        projectToUpdate.setFreelancer_username(project.getFreelancer_username());
        projectToUpdate = projectRepository.save(projectToUpdate);
        return projectToUpdate;
    }

    public Projects postProject(Projects project){

        Projects newProject = new Projects();
        newProject.setEmpUsername(project.getEmpUsername());
        newProject.setTitle(project.getTitle());
        newProject.setDescription(project.getDescription());
        newProject.setBudget_range(project.getBudget_range());
        newProject.setSkills_req(project.getSkills_req());
        newProject.setStatus(project.getStatus());
        newProject.setComplete_by(project.getComplete_by());
        newProject.setFilenames(project.getFilenames());
        newProject = projectRepository.save(newProject);
        return newProject;
    }

    public Map<String, Object> fetchOpenProjects(String sessionUsername) {
        System.out.println("Calling:");
        Set<Projects> projectEntities = projectRepository.findByEmpUsernameNotAndStatus(sessionUsername, "Open");
      //  Set<Projects> projectEntities = projectRepository.findAllByEmpUsername(sessionUsername);


        System.out.println("Size:");
        System.out.println(projectEntities);
        System.out.println(projectEntities.size());
        if(projectEntities.size() > 0) {
            return Convertors.mapOpenProjectsToResponse(projectEntities, "Open Projects fetched");

        }
        return null;
    }

    public Map<String, Object> getMyProjectDetails(String sessionUsername) {

        Set<Projects> projectEntities = projectRepository.findByEmpUsernameAndStatusNot(sessionUsername, "Closed");

        System.out.println("SizeOfProjectEntities:");
        System.out.println(projectEntities);
        System.out.println(projectEntities.size());
        if(projectEntities != null && projectEntities.size() > 0) {
            return Convertors.mapMyProjectsToResponse(projectEntities, "Fetched Successfully");
        }
        //  Set<Projects> projectEntities = projectRepository.findAllByEmpUsername(sessionUsername);

        return null;
    }
}