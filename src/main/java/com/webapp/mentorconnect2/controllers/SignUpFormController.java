package com.webapp.mentorconnect2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;

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
    public String signup(@ModelAttribute("user") Account user, @ModelAttribute("role") String role) {
        user.setRole(role);
        accountService.save(user);
        return "redirect:/login";
    }
}
