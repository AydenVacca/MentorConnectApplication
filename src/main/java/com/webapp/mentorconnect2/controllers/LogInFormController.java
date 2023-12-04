package com.webapp.mentorconnect2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInFormController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

}