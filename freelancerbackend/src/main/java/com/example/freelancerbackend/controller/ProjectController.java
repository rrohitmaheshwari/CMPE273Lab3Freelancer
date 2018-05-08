package com.example.freelancerbackend.controller;

import com.example.freelancerbackend.entity.Projects;

import com.example.freelancerbackend.models.Bids;
import com.example.freelancerbackend.models.Project;
import com.example.freelancerbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
@RequestMapping(path="/project") // This means URL's start with /user (after Application path)
public class ProjectController {

    @Autowired
    private ProjectService projectService;



    @RequestMapping(path="/postFreelancer", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postFreelancer(@RequestBody Projects project, HttpSession session)
    {

        Projects updatedProject = projectService.postFreelancer(project);

        if (updatedProject == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(updatedProject,HttpStatus.OK);
    }


 @RequestMapping(path="/post-project", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProject(@RequestBody Projects project, HttpSession session) {

        String sessionUsername = session.getAttribute("username").toString();


        project.setEmpUsername(sessionUsername);

     Projects postedProject = projectService.postProject(project);

            return new ResponseEntity<>(postedProject, HttpStatus.OK);

    }





    @RequestMapping(path="/getMyProjectDetails", method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMyProjectDetails( HttpSession session) {

        System.out.println(" username: " + session.getAttribute("username"));

        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Map<String, Object> openProjectResponse = projectService.getMyProjectDetails(session.getAttribute("username").toString());



        return new ResponseEntity( openProjectResponse, HttpStatus.OK);

    }

    @RequestMapping(path="/getMyBidDetails", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMyBidDetails( @RequestParam("user_id") String user_id, HttpSession session)
    {

        System.out.println(" username: " + session.getAttribute("username"));

        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        System.out.println(" user_id: " + user_id);

        Map<String, Object> bidDetails = projectService.getMyBidDetails(user_id);
        return new ResponseEntity( bidDetails, HttpStatus.OK);
    }

    @RequestMapping(path="/getbidheader", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBidHeader( @RequestParam("project_id") String project_id, HttpSession session)
    {

        System.out.println(" username: " + session.getAttribute("username"));

        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        System.out.println(" project_id: " + project_id);

        Long id = Long.parseLong(project_id);
        Map<String, Object> bidHeader = projectService.getBidHeader(id);
        return new ResponseEntity( bidHeader, HttpStatus.OK);
    }

    @RequestMapping(path="/getprojectdetails", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProjectDetails(@RequestParam("project_id") String project_id, HttpSession session)
    {

        System.out.println(" username: " + session.getAttribute("username"));

        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Long id = Long.parseLong(project_id);
        Projects projectDetailsResponse = projectService.fetchProjectDetails(id);

        if (projectDetailsResponse == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(projectDetailsResponse,HttpStatus.OK);
    }


    @RequestMapping(path="/postbiddata", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postBidData(@RequestBody com.example.freelancerbackend.models.Bids bid, HttpSession session)
    {


        com.example.freelancerbackend.entity.Bids newBid = projectService.postBidData(bid);
        if (newBid == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(newBid,HttpStatus.OK);
    }

    @RequestMapping(path="/getdetails", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBidTable(@RequestBody Projects project, HttpSession session)
    {

        Map<String, Object> bidsMap = projectService.getDetails(project.getProject_id());

        if (bidsMap == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(bidsMap,HttpStatus.OK);
    }
}