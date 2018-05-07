package com.example.freelancerbackend.controller;



import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpSession;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping(path="/") // This means URL's start with /user (after Application path)
public class UserController {

    @Autowired
    private UserService userService;

    Map<String, String> errorResponse = new HashMap<>();

    @RequestMapping(path="/users/authenticate", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> login(@RequestBody Users user, HttpSession session)
        {

            System.out.println(" username " + user.getUsername());
            System.out.println(" pass " + user.getPassword());
            session.setAttribute("username",user.getUsername());

            Users getuser=userService.login(user);

//            HttpStatus h=new HttpStatus(400,"The username and password you entered did not match our records. Please double-check and try again.");
//            h.set
            HttpHeaders h = new HttpHeaders();
            h.add("statusText","The username and password you entered did not match our records. Please double-check and try again.");
            if(getuser == null)
            {
                errorResponse.put("message", "The username and password you entered did not match our records. Please double-check and try again.");
                return new ResponseEntity<>(errorResponse,h, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity(getuser,HttpStatus.OK);
        }


    @RequestMapping(path="/getUser", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@RequestBody Users user, HttpSession session)
    {

        System.out.println(" username " + user.getUsername());



        return new ResponseEntity(userService.getUser(user),HttpStatus.OK);
    }



    @RequestMapping(path="/home/getdetails", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> home_getdetails( HttpSession session)
    {
        return new ResponseEntity(userService.getHomeDetails("rohit"),HttpStatus.OK);
    }



    @RequestMapping(path="/getOtherUser", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOtherUser(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userService.getUser(user),HttpStatus.OK);
    }

    @PostMapping(value = "/user/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        System.out.println("logout done");
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path="/user/updateAboutMe", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateAboutMe(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Users updatedUser = userService.updateUserFields(session.getAttribute("username").toString(), user, "about_me");
        if (updatedUser == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(path="/user/updateSummary", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSummary(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Users updatedUser = userService.updateUserFields(session.getAttribute("username").toString(), user, "summary");
        if (updatedUser == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(path="/user/updateSkills", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSkills(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Users updatedUser = userService.updateUserFields(session.getAttribute("username").toString(), user, "skills");
        if (updatedUser == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }


    @RequestMapping(path="/user/updatePhone", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePhone(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Users updatedUser = userService.updateUserFields(session.getAttribute("username").toString(), user, "phone");
        if (updatedUser == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(path="/user/updateName", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateName(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Users updatedUser = userService.updateUserFields(session.getAttribute("username").toString(), user, "name");
        if (updatedUser == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

}
