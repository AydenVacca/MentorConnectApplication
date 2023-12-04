package com.webapp.mentorconnect2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpFormController {

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

}