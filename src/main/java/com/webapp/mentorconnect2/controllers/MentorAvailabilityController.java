package com.webapp.mentorconnect2.controllers;

import com.webapp.mentorconnect2.models.MentorAvailability;
import com.webapp.mentorconnect2.repository.MentorAvailabilityService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MentorAvailabilityController {

    private final MentorAvailabilityService mentorAvailabilityRepository;

    @Autowired
    public MentorAvailabilityController(MentorAvailabilityService mentorAvailabilityRepository) {
        this.mentorAvailabilityRepository = mentorAvailabilityRepository;
    }

    @GetMapping("/mentorList")
    public String getMentorList(Model model) {
        List<MentorAvailability> mentors = mentorAvailabilityRepository.findAll();
        model.addAttribute("mentors", mentors);
        return "menteePage";
    }

    @GetMapping("/addAvailability")
    public String showAddAvailabilityForm() {
        return "addAvailability";
    }

    @PostMapping("/addAvailability")
    public String addAvailability(HttpSession session,
                        @RequestParam("day") String day,
                        @RequestParam("time") String time,
                        RedirectAttributes redirectAttributes) {

    String mentorName = (String) session.getAttribute("username");

    if (mentorName == null) {
        // Handle the missing 'mentorName' parameter, you might redirect to an error page or handle it based on your requirements
        return "redirect:/error";
    }

    // For simplicity, assuming your MentorAvailability entity has an ID field
    MentorAvailability mentorAvailability = new MentorAvailability();
    mentorAvailability.setMentorName(mentorName); // Set the mentor's name
    mentorAvailability.setAvailability(day + " " + time);

    // Save the mentorAvailability entity
    mentorAvailabilityRepository.save(mentorAvailability);

    redirectAttributes.addFlashAttribute("refresh", true);

    return "redirect:/mentorAvailability";
}


    
    @GetMapping("/mentorAvailability")
    public String mentorAvailabilityPage(HttpSession session, Model model) {
        String mentorName = (String) session.getAttribute("username");

        // Check if the user is a Mentor; otherwise, redirect to an error page or handle it as needed
        if (mentorName != null) {
            List<MentorAvailability> mentorAvailability = mentorAvailabilityRepository.findByMentorName(mentorName);
            model.addAttribute("mentorAvailability", mentorAvailability);
            return "mentorAvailability";
        } else {
            // Redirect to an error page or handle it based on your requirements
            return "redirect:/error";
        }
    }

    // Add a new endpoint for handling the form submission
    @PostMapping("/mentorAvailability/addAvailability")
    public String addAvailability(HttpSession session,
                                @RequestParam("day") String day,
                                @RequestParam("time") String time) {
        // Retrieve the username from the session
        String mentorName = (String) session.getAttribute("username");

        if (mentorName == null) {
            // Handle the missing 'mentorName' parameter, you might redirect to an error page or handle it based on your requirements
            return "redirect:/error";
        }

        MentorAvailability mentorAvailability = new MentorAvailability();
        mentorAvailability.setMentorName(mentorName);
        mentorAvailability.setAvailability(day + " " + time);

        mentorAvailabilityRepository.save(mentorAvailability);

        return "redirect:/mentorAvailability";  // Redirect back to the mentorAvailability page
    }

    @PostMapping("/removeAvailability")
    public String removeAvailability(@RequestParam("availabilityId") Long availabilityId) {
        // Implement logic to remove the availability with the specified ID
        mentorAvailabilityRepository.deleteById(availabilityId);

        // Redirect back to the mentorAvailability page after removal
        return "redirect:/mentorAvailability?refresh=true";
    }

}
