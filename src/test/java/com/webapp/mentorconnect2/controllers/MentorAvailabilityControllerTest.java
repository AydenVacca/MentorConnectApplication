package com.webapp.mentorconnect2.controllers;

import com.webapp.mentorconnect2.models.MentorAvailability;
import com.webapp.mentorconnect2.repository.MentorAvailabilityService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MentorAvailabilityControllerTest {

    @InjectMocks
    private MentorAvailabilityController mentorAvailabilityController;

    @Mock
    private MentorAvailabilityService mentorAvailabilityRepository;

    @Mock
    private HttpSession session;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMentorList() {
        List<MentorAvailability> mentorList = Arrays.asList(new MentorAvailability(), new MentorAvailability());
        when(mentorAvailabilityRepository.findAll()).thenReturn(mentorList);

        String expectedViewName = "menteePage";
        String returnedViewName = mentorAvailabilityController.getMentorList(model);

        assertEquals(expectedViewName, returnedViewName);
        verify(model).addAttribute("mentors", mentorList);
    }

    @Test
    void testShowAddAvailabilityForm() {
        String expectedViewName = "addAvailability";
        String returnedViewName = mentorAvailabilityController.showAddAvailabilityForm();

        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testAddAvailabilityRedirect() {
        when(session.getAttribute("username")).thenReturn("testMentor");
        when(mentorAvailabilityRepository.save(any(MentorAvailability.class))).thenReturn(new MentorAvailability());

        String expectedViewName = "redirect:/mentorAvailability";
        String returnedViewName = mentorAvailabilityController.addAvailability(session, "day", "time", redirectAttributes);

        assertEquals(expectedViewName, returnedViewName);
        verify(redirectAttributes).addFlashAttribute("refresh", true);
    }

    @Test
    void testMentorAvailabilityPage() {
        when(session.getAttribute("username")).thenReturn("testMentor");
        List<MentorAvailability> mentorAvailabilityList = Arrays.asList(new MentorAvailability(), new MentorAvailability());
        when(mentorAvailabilityRepository.findByMentorName("testMentor")).thenReturn(mentorAvailabilityList);

        String expectedViewName = "mentorAvailability";
        String returnedViewName = mentorAvailabilityController.mentorAvailabilityPage(session, model);

        assertEquals(expectedViewName, returnedViewName);
        verify(model).addAttribute("mentorAvailability", mentorAvailabilityList);
    }

    @Test
    void testAddAvailabilityWithoutSession() {
        when(session.getAttribute("username")).thenReturn(null);

        String expectedViewName = "redirect:/error";
        String returnedViewName = mentorAvailabilityController.addAvailability(session, "day", "time", redirectAttributes);

        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testRemoveAvailability() {
        Long availabilityId = 1L;

        String expectedViewName = "redirect:/mentorAvailability?refresh=true";
        String returnedViewName = mentorAvailabilityController.removeAvailability(availabilityId);

        assertEquals(expectedViewName, returnedViewName);
        verify(mentorAvailabilityRepository).deleteById(availabilityId);
    }
}
