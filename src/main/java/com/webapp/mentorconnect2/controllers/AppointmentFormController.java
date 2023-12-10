package com.webapp.mentorconnect2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.webapp.mentorconnect2.models.Appointment;
import com.webapp.mentorconnect2.repository.AppointmentService;

@Controller
public class AppointmentFormController{
    @Autowired
    private AppointmentService appointmentDB;

    @Autowired
    public void setAppointmentRepository(AppointmentService appointmentDB){
        this.appointmentDB = appointmentDB;
    }
    
}