package com.webapp.mentorconnect2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.webapp.mentorconnect2.models.Appointment;
import com.webapp.mentorconnect2.repository.AppointmentService;
import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppointmentController {
    @Autowired
    private final AppointmentService appointmentDB;

    @Autowired
    public void setAppointmentRepository(AppointmentService appointmentDB){
        this.appointmentDB = appointmentDB;
    }
    @GetMapping("/Appointment")
    public String appointmentPage(){
        model.addAttribute("appointment", new Appointment());
        return "Appointment";
    }   
    //Create Appointment
    @PostMapping("/Appointment")
    public String addAppointment(HttpSession session,
                        @RequestParam("mentorID") long mentorID,
                        @RequestParam("menteeID")long menteeID,
                        @RequestParam("confirmed") boolean confirmed,
                        @RequestParam("day") String day,
                        @RequestParam("time") String time,
                        RedirectAttributes redirectAttributes) {

    String username = (String) session.getAttribute("username");

    //Instantiate appointment
    Appointment appointment = new Appointment();
    //Set attributes for appointment
    appointment.setMentorID(mentorID); 
    appointment.setMenteeID(menteeID);
    appointment.setConfirmed(confirmed);
    appointment.setDate(day + " " + time);

    // Save the appointment
    appointmentDB.save(appointment);
    redirectAttributes.addFlashAttribute("refresh", true);

    return "redirect:/Appointment";
}

 
    @GetMapping("/ConfirmAppointment"){
        return "ConfirmAppointment";
        
    }



    @PostMapping("/ConfirmAppointment")
    public String createAppointmentPage(HttpSession session, Model model) {
        String mentorName = (String) session.getAttribute("username");

        // Check if the user is a Mentor, and have them confirm the appointment
        if (mentorName != null) {
            List<Appointment> appointments = appointmentDB.findByMentorName(mentorName);
            model.addAttribute("appointment", appointment);
            return "appointment";
        } else {
            // Redirect to error page
            return "redirect:/error";
        }
    }

    //Edit Appointment
    @GetMapping("/editAppointment/{appointmentID}")
    public String editComment(@PathVariable("appointmentID") long id, Model model){
        Appointment appointment = appointmentDB.findById(id).orElseThrow(() -> new IllegalArgumentException("Appointment " + id + " not found."));

        model.addAttribute("appointment", appointment);
        return "editAppointment";
    }

    //Update the page
    @PostMapping("/edit-appointment/{appointmentID}")
    public String editAppointment(@PathVariable("appointmentID") long id, @ModelAttribute Appointment updatedAppointment, HttpSession session){
        Appointment appointment = appointmentDB.findById(id).orElseThrow(() -> new IllegalArgumentException("Appointment " + id + " not found."));
        appointment.setContent(updatedAppointment.getContent());
        long authorID = (long) session.getAttribute("userId");
        appointment.setAppointmentID(appointmentID);
        appointmentDB.save(appointment);
        return "redirect:/appointment/" + appointment.getAppointmentID();    
    }

    //Delete Appointment
        @GetMapping("/deleteAppointment/{AppointmentID}")
        public String deleteAppointment(@PathVariable("AppointmentID") long id, Model model){
            Appointment appointment = appointmentDB.findById(id).orElseThrow(()-> new IllegalArgumentException("Appointment " + id + " not found."));
            
            appointmentDB.delete(appointment);
            return "redirect:/home";
        }
        public AppointmentService getAppointmentDB() {
            return appointmentDB;
        }
}
