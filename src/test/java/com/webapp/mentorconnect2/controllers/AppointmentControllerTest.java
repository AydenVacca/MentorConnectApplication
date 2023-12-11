package com.webapp.mentorconnect2.controllers;

import com.webapp.mentorconnect2.models.Appointment;
import com.webapp.mentorconnect2.repository.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AppointmentControllerTest{

    @InjectMocks
    private AppointmentController appointmentController;

    @Mock
    private AppointmentService appointmentDB;
    @Mock
    private HttpSession session;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowAppointmentCreationPage(){
        String expected = "appointmentCreation";
        String returned = appointmentController.showAppointmentCreationPage();

        assertEquals(expected, returned);
    }

    @Test
    void testEditAppointment(){
        long testID = 2302;
        Appointment app = new Appointment(2302, 1320, 2310, "09-09-2022", "6:00am", true);
        when(appointmentDB.findById(testID)).thenReturn(java.util.Optional.of(app));
        String returned = "appointmentCreation";
        String expected = appointmentController.editAppointment(testID, app, session);
    }
}
