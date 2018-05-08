package com.example.freelancerbackend.service;

import com.example.freelancerbackend.entity.Projects;
import com.example.freelancerbackend.helpers.Converter;
import com.example.freelancerbackend.models.User;
import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(Users testuser) {

        Users foundUser = userRepository.findByUsernameAndPassword(testuser.getUsername(),testuser.getPassword());
        if (foundUser == null) {
            return null;
        }
        User response = Converter.mapUserEntityToResponse(foundUser);
        return response;


    }

    public User getUser(String username) {
       // return userRepository.findByUsername(testuser.getUsername());


        Users foundUser = userRepository.findByUsername(username);
        if (foundUser == null) {
            return null;
        }
        User response = Converter.mapUserEntityToResponse(foundUser);
        return response;
    }

    public int getHomeDetails(String testuser) {

        List<Projects> ob1;
        return 1;
    }

    public User registerUser(Users user){

        Users newUser = new Users();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setName(user.getName());
        newUser.setLooking_for(user.getLooking_for());
        newUser = userRepository.save(newUser);
        if (newUser == null) {
            return null;
        }
        User response = Converter.mapUserEntityToResponse(newUser);
        return response;
    }


    @Transactional
    public Users updateUserFields(String username, Users user, String fieldToUpdate) {

        Users updatedUser = userRepository.findByUsername(username);
        System.out.println("updatedUser: " + updatedUser);
        if (updatedUser == null) {
            return null;
        }
        switch (fieldToUpdate) {
            case "about_me":
                updatedUser.setAbout_me(user.getAbout_me());
                break;
            case "summary":
                updatedUser.setSummary(user.getSummary());
                break;
            case "skills":
                updatedUser.setSkills(user.getSkills());
                break;
            case "phone":
                updatedUser.setPhone(user.getPhone());
                break;
            case "name":
                updatedUser.setName(user.getName());
                break;
        }

        updatedUser = userRepository.save(updatedUser);
        return updatedUser;
    }

}