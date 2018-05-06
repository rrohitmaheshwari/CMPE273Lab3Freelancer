package com.example.freelancerbackend.controller;



import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user") // This means URL's start with /user (after Application path)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path="/login", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> login(@RequestBody Users user, HttpSession session)
        {

            System.out.println(" user " + user.getEmail());
            System.out.println(" user " + user.getPassword());
            session.setAttribute("username",user.getEmail());

            return new ResponseEntity(userService.login(user),HttpStatus.OK);
        }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("username"));
        System.out.println("logout done");
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }



    }
