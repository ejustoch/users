package com.users.controller;

import com.users.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiuser/v1")
public class UsersController {
    
    @Autowired
    UsersService usersService;
    
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public Object user() {

        return usersService.user();
    }

}
