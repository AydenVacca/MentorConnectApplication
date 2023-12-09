package com.webapp.mentorconnect2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogInFormController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/home")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        // Retrieve the user by username
        Account user = accountService.findByUsername(username);

        // Check if the user exists and the password is correct
        if (user != null && user.getPassword().equals(password)) {
            // Store the username and role in the session
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());

            // Redirect to home
            return "redirect:/home";
        } else {
            // Add an error message to the model and return to the login page
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
