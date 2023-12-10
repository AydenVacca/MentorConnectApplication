package com.webapp.mentorconnect2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.models.MentorAvailability;
import com.webapp.mentorconnect2.repository.AccountService;
import com.webapp.mentorconnect2.repository.ForumPostService;
import com.webapp.mentorconnect2.repository.MentorAvailabilityService;

import java.util.List;

@Controller
public class HomeFormController {

    @Autowired
    private AccountService accountDB;

    @Autowired
    private ForumPostService forumPostDB;

    @Autowired
    private MentorAvailabilityService mentorAvailabilityService;

    @GetMapping("/home")
    public ModelAndView homePage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("home");

        // Pull all items from db and add to the list object
        modelAndView.addObject("Accounts", accountDB.findAll());
        modelAndView.addObject("ForumPost", forumPostDB.findAll());
        modelAndView.addObject("homeFormController", this);

        // Retrieve the role from the session
        String userRole = (String) session.getAttribute("role");

        // Default role if not found in session (replace with your actual default)
        userRole = (userRole != null) ? userRole : "defaultRole";

        modelAndView.addObject("role", userRole);

        // Fetch and add mentor availability to the model
        if ("Mentee".equals(userRole)) {
            List<MentorAvailability> mentorAvailability = mentorAvailabilityService.findAll();
    
            // Log the mentor availability for debugging
            mentorAvailability.forEach(availability -> {
                System.out.println("Mentor Name: " + availability.getMentorName() + ", Availability: " + availability.getAvailability());
            });
    
            modelAndView.addObject("mentorAvailability", mentorAvailability);
        }


        long userID = (long) session.getAttribute("userId");
        modelAndView.addObject("userID", userID);

        return modelAndView;
    }


    @Autowired
    public void setAccountService(AccountService accountDB){
        this.accountDB = accountDB;
    }

    @Autowired
    public void setForumPostService(ForumPostService forumPostDB){
        this.forumPostDB = forumPostDB;
    }

    @GetMapping("/appointmentCreation")
    public String appointmentCreationPage() {
        return "appointmentCreation";
    }

    @GetMapping("/fetchRole")
    @ResponseBody
    public String fetchRole(HttpSession session) {
        // Retrieve the role from the session
        String userRole = (String) session.getAttribute("role");

        // Default role if not found in session (replace with your actual default)
        userRole = (userRole != null) ? userRole : "defaultRole";

        return userRole;
    }

    public String getAuthorUsername(long authorID) {
        return accountDB.findById(authorID)
                .map(Account::getUsername)
                .orElse("Unknown");
    }

    
}