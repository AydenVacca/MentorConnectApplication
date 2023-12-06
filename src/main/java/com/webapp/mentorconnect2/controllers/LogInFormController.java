package com.webapp.mentorconnect2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInFormController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/home")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String role) {

        // Redirect to home with role as a query parameter
        return "redirect:/home?role=" + role;
    }
}
