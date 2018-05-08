package com.example.freelancerbackend.service;

import com.example.freelancerbackend.converters.Convertors;
import com.example.freelancerbackend.entity.Bids;
import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.helpers.Converter;
import com.example.freelancerbackend.repository.BidRepository;
import com.example.freelancerbackend.repository.ProjectRepository;
import com.example.freelancerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BidRepository bidsRepository;

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
      //  if(projectEntities != null && projectEntities.size() > 0) {
            return Convertors.mapMyProjectsToResponse(projectEntities, "Fetched Successfully");
        //}
        //  Set<Projects> projectEntities = projectRepository.findAllByEmpUsername(sessionUsername);

        //return null;
    }

    public Map<String, Object> getMyBidDetails(String user_id) {

        Optional<Users> user = userRepository.findById(Long.parseLong(user_id));

        if ( !user.isPresent()) {
            return null;
        }

        Users foundUser = user.get();

        Set<Bids> myBids = foundUser.getBids();

        System.out.println("myBids:");
        System.out.println(myBids);
        System.out.println(myBids.size());

            return Convertors.mapMyBidsToResponse(myBids, "Fetched Successfully");

    }

    public Map<String, Object> getBidHeader(Long project_id) {

        Optional<Projects> projectOpt = projectRepository.findById(project_id);

        if ( !projectOpt.isPresent()) {
            return null;
        }

        Projects projectDetails = projectOpt.get();
        System.out.println(projectDetails);

        if(projectDetails != null) {
            return Convertors.mapBidHeaderToResponse(projectDetails, "Fetched Successfully");
        }

        return null;
    }

    public Projects fetchProjectDetails(Long project_id) {

        Optional<Projects> projectOpt = projectRepository.findById(project_id);

        if ( !projectOpt.isPresent()) {
            return null;
        }

        Projects projectDetails = projectOpt.get();
        System.out.println(projectDetails);

        if(projectDetails != null) {
            return projectDetails;
        }

        return null;
    }

    public Bids postBidData(com.example.freelancerbackend.models.Bids bid){

        Bids newBid = new Bids();
        Optional<Users> u = userRepository.findById(bid.getUser_id());
        Users foundUser = u.get();

        newBid.setUserEntity(foundUser);

        Optional<Projects> p = projectRepository.findById(bid.getProject_id());
        Projects foundProject = p.get();

        newBid.setProjectEntity(foundProject);

        Bids foundBid = bidsRepository.findByUserEntityAndProjectEntity(foundUser, foundProject);

        if (foundBid != null) {
            bidsRepository.delete(foundBid);
        }

        newBid.setBid_price(bid.getBid_price());
        newBid.setDays_req(bid.getDays_req());

        System.out.println("newBid: " + newBid);
        newBid = bidsRepository.save(newBid);

        if (newBid == null) {
            return null;
        }

        return newBid;
    }

    public Map<String, Object> getDetails(Long project_id) {

        Optional<Projects> projectOpt = projectRepository.findById(project_id);

        if ( !projectOpt.isPresent()) {
            return null;
        }

        Projects projectDetails = projectOpt.get();
        System.out.println(projectDetails);

        if(projectDetails != null) {
            return Convertors.mapBidTableToResponse(projectDetails, "Fetched Successfully");
        }

        return null;
    }

}