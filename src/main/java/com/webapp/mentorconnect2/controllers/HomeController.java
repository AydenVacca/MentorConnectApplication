package com.webapp.mentorconnect2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.mentorconnect2.repository.AccountService;
import com.webapp.mentorconnect2.repository.ForumPostService;

@Controller
public class HomeController {
    
    @Autowired
    private AccountService accountDB;

    @Autowired
    private ForumPostService forumPostDB;

    @GetMapping("/home")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("home");

        //Pull all items from db and add to list object
        modelAndView.addObject("Accounts", accountDB.findAll());
        
        modelAndView.addObject("ForumPost", forumPostDB.findAll());
    
        return modelAndView;
    }

    
}
