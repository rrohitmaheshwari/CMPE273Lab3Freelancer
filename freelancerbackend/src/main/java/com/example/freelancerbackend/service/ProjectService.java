package com.example.freelancerbackend.service;

import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
        if (projectToUpdate == null) {
            return null;
        }
        return projectToUpdate;
    }

    public Projects postProject(Projects project){

        Projects newProject = new Projects();
        newProject.setEmp_username(project.getEmp_username());
        newProject.setTitle(project.getTitle());
        newProject.setDescription(project.getDescription());
        newProject.setBudget_range(project.getBudget_range());
        newProject.setSkills_req(project.getSkills_req());
        newProject.setStatus(project.getStatus());
        newProject.setComplete_by(project.getComplete_by());
        newProject.setFilenames(project.getFilenames());

        newProject = projectRepository.save(newProject);

        if (newProject == null) {
            return null;
        }

        return newProject;
    }

}