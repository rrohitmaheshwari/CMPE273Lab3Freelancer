package com.example.freelancerbackend.helpers;

import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.models.User;

public class Converter {
    public static User mapUserEntityToResponse (Users user) {
        User response = new User();

        response.setUser_id(user.getUser_id());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setSummary(user.getSummary());
        response.setPhone(user.getPhone());
        response.setAbout_me(user.getAbout_me());
        response.setSkills(user.getSkills());
        response.setLooking_for(user.getLooking_for());

        return response;
    }

}
