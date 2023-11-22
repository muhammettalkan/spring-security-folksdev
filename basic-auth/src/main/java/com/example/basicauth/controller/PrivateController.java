package com.example.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    public String hello(){
        return "Hello from private API controller";
    }

    @GetMapping("/user")
    public String helloUser(){
        return "Hello to user from private API controller";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello to admin from private API controller";
    }

}
