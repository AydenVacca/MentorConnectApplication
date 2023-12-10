package com.webapp.mentorconnect2.controllers;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.mentorconnect2.models.Rating;
import com.webapp.mentorconnect2.repository.RatingService;

import jakarta.servlet.http.HttpSession;


@Controller
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/rateMentor")
    public String rateMentorForm(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "rateMentor";
    }

// ... other parts of the RatingController ...

@PostMapping("/submitRating")
public String submitRating(HttpSession session,
                           @RequestParam("mentorName") String mentorName,
                           @RequestParam("rating") int rating,
                           RedirectAttributes redirectAttributes) {
    String menteeName = (String) session.getAttribute("username");

    if (menteeName == null) {
        return "redirect:/login";
    }

    if (rating < 1 || rating > 5) {
        redirectAttributes.addFlashAttribute("error", "Rating must be between 1 and 5");
        return "redirect:/rateMentor";
    }
    Rating newRating = new Rating();
    newRating.setMenteeName(menteeName); // Assuming you have a setter method for menteeName
    newRating.setMentorName(mentorName); // Assuming you have a setter method for mentorName
    newRating.setRating(rating);         // Assuming you have a setter method for rating

    
    ratingService.save(newRating);

    redirectAttributes.addFlashAttribute("successMessage", "Rating submitted successfully!");
    return "redirect:/home";
}

@GetMapping("/mentorRatings")
public String mentorRatings(Model model) {
    // Fetch the average ratings for each mentor
    var ratings = ratingService.findAverageRatingsByMentor();

    // Add the ratings to the model, making them available to the view
    model.addAttribute("ratings", ratings);

    // Return the name of the Thymeleaf template that will display these ratings
    return "mentorRatings";
}
    // Additional methods can be implemented to view ratings, etc.
}

