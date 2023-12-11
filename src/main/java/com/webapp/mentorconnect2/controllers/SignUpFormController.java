package com.webapp.mentorconnect2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignUpFormController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new Account());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") Account user, HttpSession session) {
        // Validate password length
        if (user.getPassword().length() < 5) {
            session.setAttribute("error", "Password length must be 5 or more characters.");
            return "redirect:/signup?error=password";
        }
        session.removeAttribute("error");
        // Validate email (you can add more sophisticated email validation)
        if (!isValidEmail(user.getEmail())) {
            session.setAttribute("error", "Must be ilstu email.");
            return "redirect:/signup?error=email";
        }

        // Save the user if validations pass
        accountService.save(user);

        // Store the username and role in the session
        session.setAttribute("username", user.getUsername());
        session.setAttribute("role", user.getRole());

        return "redirect:/login";
    }

    private boolean isValidEmail(String email) {
        // Regular expression for a simple email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@ilstu.edu$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
