package com.webapp.mentorconnect2.controllers;

import com.webapp.mentorconnect2.models.MentorAvailability;
import com.webapp.mentorconnect2.repository.MentorAvailabilityService;

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
        List<MentorAvailability> mentors = mentorAvailabilityRepository.findAll();
        model.addAttribute("mentors", mentors);
        return "menteePage";
    }

    @GetMapping("/addAvailability")
    public String showAddAvailabilityForm() {
        return "addAvailability";
    }

    @PostMapping("/addAvailability")
    public String addAvailability(@RequestParam("day") String day,
                              @RequestParam("time") String time) {

    // For simplicity, assuming your MentorAvailability entity has an ID field
    MentorAvailability mentorAvailability = new MentorAvailability();
    mentorAvailability.setAvailability(day + " " + time);

    // Save the mentorAvailability entity
    mentorAvailabilityRepository.save(mentorAvailability);

    return "redirect:/home";
}

}
