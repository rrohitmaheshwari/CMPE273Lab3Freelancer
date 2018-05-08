package com.example.freelancerbackend.controller;



import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.models.User;
import com.example.freelancerbackend.service.ProjectService;
import com.example.freelancerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping(path="/") // This means URL's start with /user (after Application path)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    Map<String, String> errorResponse = new HashMap<>();

    @RequestMapping(path="/users/authenticate", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> login(@RequestBody Users user, HttpSession session)
        {

            System.out.println(" username " + user.getUsername());
            System.out.println(" pass " + user.getPassword());
            session.setAttribute("username",user.getUsername());

            User getuser=userService.login(user);

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


        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        User response = userService.getUser(session.getAttribute("username").toString());

        if (response == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(response,HttpStatus.OK);

     //   return new ResponseEntity(userService.getUser(user),HttpStatus.OK);
    }


//
//    @RequestMapping(path="/home/getdetails", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> home_getdetails( HttpSession session)
//    {
//        return new ResponseEntity(userService.getHomeDetails("rohit"),HttpStatus.OK);
//    }

    @RequestMapping(path="/home/getdetails", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> openProjects(HttpSession session) {

        String sessionUsername = session.getAttribute("username").toString();
        System.out.println("home.getdetails. Session username"+sessionUsername);

        Map<String, Object> openProjectResponse = projectService.fetchOpenProjects(sessionUsername);

     //   return new ResponseEntity(userService.getUser(sessionUsername),HttpStatus.OK);

        return new ResponseEntity<>(openProjectResponse, HttpStatus.OK);


    }


    @RequestMapping(path="/getOtherUser", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOtherUser(@RequestBody Users user, HttpSession session)
    {
        System.out.println("getOtherUsergetOtherUsergetOtherUsergetOtherUsergetOtherUser ");
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));
        if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userService.getUser(user.getUsername()),HttpStatus.OK);
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


    @RequestMapping(path="/users/register", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@RequestBody Users user, HttpSession session)
    {
        System.out.println(" Logged in User's username: " + session.getAttribute("username"));

        User response = userService.registerUser(user);

        if (response == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpSession session) {

        String sessionUsername = session.getAttribute("username").toString();
        System.out.println(sessionUsername);
        try {
            String current = new java.io.File( "." ).getCanonicalPath();

            FileCopyUtils.copy(file.getBytes(), new File(current+"/src/main/resources/static/ProfileImage/" + sessionUsername+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  String fileName = file.getOriginalFilename();
        //modelMap.addAttribute("fileName", fileName);
        return "fileupload";


    }



}
