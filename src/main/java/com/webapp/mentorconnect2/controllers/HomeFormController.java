package com.webapp.mentorconnect2.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;
import com.webapp.mentorconnect2.repository.ForumPostService;

@Controller
public class HomeFormController {

    @Autowired
    private AccountService accountDB;

    @Autowired
    private ForumPostService forumPostDB;

    @Autowired
    public void setAccountService(AccountService accountDB){
        this.accountDB = accountDB;
    }

    @Autowired
    public void setForumPostService(ForumPostService forumPostDB){
        this.forumPostDB = forumPostDB;
    }

    @GetMapping("/home")
    public ModelAndView homePage(@RequestParam(name = "role", required = false) String userRole) {
        ModelAndView modelAndView = new ModelAndView("home");

        // Pull all items from db and add to the list object
        modelAndView.addObject("Accounts", accountDB.findAll());
        modelAndView.addObject("ForumPost", forumPostDB.findAll());
        modelAndView.addObject("homeFormController", this);

        // Default role if not found in request parameters (replace with your actual default)
        userRole = (userRole != null) ? userRole : "defaultRole";

        modelAndView.addObject("role", userRole);

        return modelAndView;
    }

    public String getAuthorUsername(long authorID) {
        Optional<Account> author = accountDB.findById(authorID);
        return author.get().getUsername();
    }
}
