package com.example.freelancerbackend.converters;

import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.models.Bids;
import com.example.freelancerbackend.models.Project;
import com.example.freelancerbackend.models.User;
import com.example.freelancerbackend.entity.Users;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Convertors {

    public static User mapUserEntityToUserResponse(Users userEntity, String message){

        User userResponse = new User();

        userResponse.setUser_id     (userEntity.getUser_id());
        userResponse.setUsername    (userEntity.getUsername());
        userResponse.setEmail       (userEntity.getEmail());
        userResponse.setName        (userEntity.getName());
        userResponse.setSummary     (userEntity.getSummary());
        userResponse.setPhone       (userEntity.getPhone());
        userResponse.setAbout_me    (userEntity.getAbout_me());
        userResponse.setSkills      (userEntity.getSkills());
        userResponse.setLooking_for (userEntity.getLooking_for());
        userResponse.setMessage     (message);

        return userResponse;
    }

    public static Project mapProjectEntityToProjectResponse(Projects projectEntity, String message) {

        Project projectResponse = new Project();

        if(projectEntity != null) {
            projectResponse.setEmpUsername(projectEntity.getEmpUsername());
            projectResponse.setBudget_range(projectEntity.getBudget_range());
            projectResponse.setComplete_by(new SimpleDateFormat("dd/MM/YYYY").format(projectEntity.getComplete_by()));
            projectResponse.setDescription(projectEntity.getDescription());
            projectResponse.setFilenames(projectEntity.getFilenames());
            projectResponse.setFreelancer_username(projectEntity.getFreelancer_username());
            projectResponse.setProject_id(projectEntity.getProject_id());
            projectResponse.setSkills_req(projectEntity.getSkills_req());
            projectResponse.setStatus(projectEntity.getStatus());
            projectResponse.setTitle(projectEntity.getTitle());
        }
        projectResponse.setMessage( message );


        return projectResponse;
    }

    public static Map<String, Object> mapOpenProjectsToResponse(Set<Projects> projectEntities, String message) {

        Set<Project> projectSetResponse = new HashSet<>();

        projectEntities.stream()
                       .forEach(projectEntity -> {
                           Project project = new Project();
                           project.setProject_id    ( projectEntity.getProject_id() );
                           project.setTitle         ( projectEntity.getTitle() );
                           project.setDescription   ( projectEntity.getDescription() );
                           project.setSkills_req    ( projectEntity.getSkills_req() );
                           project.setBid_count     ( projectEntity.getBids().size() );
                           project.setEmpUsername  ( projectEntity.getEmpUsername() );
                           project.setBudget_range  ( projectEntity.getBudget_range() );
                           project.setStatus        ( projectEntity.getStatus() );
                           project.setComplete_by   ( projectEntity.getComplete_by() );
                           projectSetResponse.add(project);
                       });

        Map<String, Object> openProjectResponse = new HashMap<>();
        openProjectResponse.put("projects", projectSetResponse);
        openProjectResponse.put("message", message);

        return openProjectResponse;
    }

    public static Map<String, Object> mapBidsDetailsToResponse(Projects projectEntity, String message) {

        Set<Bids> bidsSet = new HashSet<>();

        projectEntity.getBids().stream()
                .forEach((bidsEntity -> {

                    Bids bid = new Bids();
                    bid.setId           ( bidsEntity.getId() );
                    bid.setUser_id      ( bidsEntity.getUserEntity().getUser_id() );
                    bid.setProject_id   ( bidsEntity.getProjectEntity().getProject_id() );
                    bid.setBid_price    ( bidsEntity.getBid_price() );
                    bid.setDays_req     ( bidsEntity.getDays_req() );
                    bid.setUsername     ( bidsEntity.getUserEntity().getUsername() );
                    bid.setName         ( bidsEntity.getUserEntity().getName() );
                    bidsSet.add(bid);
                }));

        Map<String, Object> openProjectResponse = new HashMap<>();
        openProjectResponse.put("bidDetails", bidsSet);
        openProjectResponse.put("message", message);

        return openProjectResponse;
    }

    public static String fetchSessionUsername() {
        return (String)((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("username");
    }

    public static Map<String, Object> mapMyProjectsToResponse(Set<Projects> projectEntities, String message) {

        Set<Project> projectSetResponse = new HashSet<>();

        projectEntities.stream()
                .forEach(projectEntity -> {
                    Project project = new Project();
                    project.setProject_id    ( projectEntity.getProject_id() );
                    project.setTitle         ( projectEntity.getTitle() );
                    project.setDescription   ( projectEntity.getDescription() );
                    project.setSkills_req    ( projectEntity.getSkills_req() );
                    project.setEmpUsername  ( projectEntity.getEmpUsername() );
                    project.setBudget_range  ( projectEntity.getBudget_range() );
                    project.setStatus        ( projectEntity.getStatus() );
                    project.setComplete_by   ( projectEntity.getComplete_by() );
                    float averageBid = 0;
                    for (com.example.freelancerbackend.entity.Bids bidEntity : projectEntity.getBids()) {
                        averageBid += Float.parseFloat(bidEntity.getBid_price());
                    }
                    project.setAverageBid(averageBid / projectEntity.getBids().size());
                    projectSetResponse.add(project);
                });

        Map<String, Object> openProjectResponse = new HashMap<>();
        openProjectResponse.put("projects", projectSetResponse);
        openProjectResponse.put("message", message);

        return openProjectResponse;
    }

    public static Map<String, Object> mapMyBidsToResponse(Set<com.example.freelancerbackend.entity.Bids> bidEntities, String message) {

        Set<com.example.freelancerbackend.models.Bids> bidSetResponse = new HashSet<>();

        bidEntities.stream()
                .forEach(bidEntity -> {

                    com.example.freelancerbackend.models.Bids bid = new com.example.freelancerbackend.models.Bids();
                    Projects project = bidEntity.getProjectEntity();

                    bid.setId(project.getProject_id());
                    bid.setBid_price(bidEntity.getBid_price());
                    bid.setProjectTitle(project.getTitle());
                    bid.setProjectEmployer(project.getEmpUsername());
                    bid.setProjectTitle(project.getTitle());
                    bid.setProjectStatus(project.getStatus());
                    bid.setProject_id(project.getProject_id());
                    float averageBid = 0;
                    for (com.example.freelancerbackend.entity.Bids allBidEntity : project.getBids()) {
                        averageBid += Float.parseFloat(allBidEntity.getBid_price());
                    }
                    bid.setProjectAverageBid(averageBid / project.getBids().size());

                    bidSetResponse.add(bid);
                });

        Map<String, Object> openProjectResponse = new HashMap<>();
        openProjectResponse.put("projects", bidSetResponse);
        openProjectResponse.put("message", message);

        return openProjectResponse;
    }

    public static Map<String, Object> mapBidHeaderToResponse(Projects projectEntity, String message) {

        Set<Project> projectSetResponse = new HashSet<>();

        Project project = new Project();
        project.setProject_id    ( projectEntity.getProject_id() );
        project.setTitle         ( projectEntity.getTitle() );
        project.setDescription   ( projectEntity.getDescription() );
        project.setSkills_req    ( projectEntity.getSkills_req() );
        project.setEmpUsername  ( projectEntity.getEmpUsername() );
        project.setBid_count     ( projectEntity.getBids().size() );
        project.setBudget_range  ( projectEntity.getBudget_range() );
        project.setStatus        ( projectEntity.getStatus() );
        project.setComplete_by   ( projectEntity.getComplete_by() );
        float averageBid = 0;
        for (com.example.freelancerbackend.entity.Bids bidEntity : projectEntity.getBids()) {
            averageBid += Float.parseFloat(bidEntity.getBid_price());
        }
        project.setAverageBid(averageBid / projectEntity.getBids().size());
        projectSetResponse.add(project);

        Map<String, Object> openProjectResponse = new HashMap<>();
        openProjectResponse.put("projects", projectSetResponse);
        openProjectResponse.put("message", message);

        return openProjectResponse;
    }
}
