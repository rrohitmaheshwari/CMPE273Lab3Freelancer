package com.example.freelancerbackend.controller;

import com.example.freelancerbackend.entity.Projects;

import com.example.freelancerbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
@RequestMapping(path="/") // This means URL's start with /user (after Application path)
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(path="/project/postFreelancer", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postFreelancer(@RequestBody Projects project, HttpSession session)
    {

        Projects updatedProject = projectService.postFreelancer(project);

        if (updatedProject == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(updatedProject,HttpStatus.OK);
    }

    @RequestMapping(path="/project/post-project", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProject(@RequestBody Projects project, HttpSession session)
    {

        Projects newProject = projectService.postProject(project);

        if (newProject == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(newProject,HttpStatus.OK);
    }


}