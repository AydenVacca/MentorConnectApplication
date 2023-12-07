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
        // Retrieve mentor's availability (replace "MentorName" with the actual field name)
        List<MentorAvailability> mentorAvailability = mentorAvailabilityRepository.findAll();

        // Add mentor's availability to the model
        model.addAttribute("mentorAvailability", mentorAvailability);

        // Add other necessary data to the model as needed

        return "menteePage";
    }

    @GetMapping("/addAvailability")
    public String showAddAvailabilityForm() {
        return "addAvailability";
    }

    @PostMapping("/addAvailability")
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

        return "redirect:/mentorList";  // Assuming you want to redirect to the mentor list page after adding availability
    }
}