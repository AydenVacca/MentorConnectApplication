package com.webapp.mentorconnect2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        // Your login logic here

        // Pass the selected role to the home screen
        model.addAttribute("role", role);

        return "redirect:/home";
    }
}
