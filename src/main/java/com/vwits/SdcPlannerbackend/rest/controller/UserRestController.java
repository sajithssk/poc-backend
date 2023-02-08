package com.vwits.SdcPlannerbackend.rest.controller;

import com.vwits.SdcPlannerbackend.entity.User;
import com.vwits.SdcPlannerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private UserService service;

    @GetMapping("/findall")
    public List<User> findAll(){
        return this.service.findAll();
    }
    @PostMapping("/login")
    public ResponseEntity<?> handleLogin(@RequestBody User u){
        User foundUserModel =  this.service.findByEmail(u.getEmail());//fetch userObject from database
        //using the username sent by the client
        if (foundUserModel.getPassword().equals(u.getPassword())) { //check the password sent by the user and password from the database
            ResponseEntity<User> entity=new ResponseEntity<User>(u, HttpStatus.OK);
            return entity;
        } else {
            ResponseEntity<String> entity=new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
            return entity;
        }
    }}
