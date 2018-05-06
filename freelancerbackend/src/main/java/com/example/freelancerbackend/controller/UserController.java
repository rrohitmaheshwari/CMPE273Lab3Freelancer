package com.example.freelancerbackend.controller;



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


    @PostMapping(value = "/login",  consumes = {"application/x-www-form-urlencoded"})
        public ResponseEntity<?> login(@RequestBody  String user, HttpSession session)
        {

            System.out.println(" user " + user);


            return new ResponseEntity("hi",HttpStatus.OK);
        }


    }
