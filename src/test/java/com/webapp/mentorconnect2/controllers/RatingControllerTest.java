package com.webapp.mentorconnect2.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webapp.mentorconnect2.repository.RatingService;
import org.springframework.ui.Model;


import com.webapp.mentorconnect2.models.Rating;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
// Remove the existing import statement for org.springframework.ui.Model
// Add the import statement for org.springframework.ui.Model to the existing import block


@ExtendWith(SpringExtension.class)
public class RatingControllerTest {

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    private MockHttpSession session;
    private RedirectAttributes redirectAttributes;
    private Model model;

    @BeforeEach
    public void setUp() {
        session = new MockHttpSession();
        redirectAttributes = mock(RedirectAttributes.class);
        model = mock(Model.class);
    }

    @Test
    public void whenNotLoggedIn_rateMentorForm_ShouldRedirectToLogin() {
        String view = ratingController.rateMentorForm(session);
        assertEquals("redirect:/login", view);
    }

    @Test
    public void whenLoggedIn_rateMentorForm_ShouldReturnRateMentorView() {
        session.setAttribute("username", "user1");
        String view = ratingController.rateMentorForm(session);
        assertEquals("rateMentor", view);
    }

    @Test
    public void whenNotLoggedIn_submitRating_ShouldRedirectToLogin() {
        String view = ratingController.submitRating(session, "mentor1", 5, redirectAttributes);
        assertEquals("redirect:/login", view);
    }

    @Test
    public void whenInvalidRating_submitRating_ShouldRedirectWithErrorMessage() {
        session.setAttribute("username", "user1");
        String view = ratingController.submitRating(session, "mentor1", 6, redirectAttributes);
        assertEquals("redirect:/rateMentor", view);
        verify(redirectAttributes).addFlashAttribute(eq("error"), anyString());
    }

    // ...

    @Test
    public void mentorRatings_ShouldAddRatingsToModelAndReturnView() {
        String view = ratingController.mentorRatings((org.springframework.ui.Model) model);
        assertEquals("mentorRatings", view);
        verify(model).addAttribute(eq("ratings"), anyObject());
    }
}
