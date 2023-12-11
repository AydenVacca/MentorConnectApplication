package com.webapp.mentorconnect2.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AppointmentTest {
    private Appointment appointment;

    @BeforeEach
    void setUp(){
        appointment = new Appointment();
    }

    @Test
    void testConstructor(){
        appointment = new Appointment(1235, 1234, 1238, "07-09-2023", "5:00pm", true);
        assertNotNull(appointment);
        assertEquals(1235, appointment.getAppointmentID());
        assertEquals(1238, appointment.getMentorID());
        assertEquals(1235, appointment.getMenteeID());
        assertEquals("07-09-2023", appointment.getDate());
        assertEquals("5:00pm", appointment.getTime());
        assertEquals(true, appointment.getConfirmed());

    }
    @Test
    void testSetAndGet(){
        appointment.setAppointmentID(1235);
        appointment.setMenteeID(1234);
        appointment.setMentorID(1238);
        appointment.setDate("07-09-2023");
        appointment.setTime("5:00pm");
        appointment.setConfirmed(true);

        assertEquals(1235, appointment.getAppointmentID());
        assertEquals(1238, appointment.getMentorID());
        assertEquals(1235, appointment.getMenteeID());
        assertEquals("07-09-2023", appointment.getDate());
        assertEquals("5:00pm", appointment.getTime());
        assertEquals(true, appointment.getConfirmed());
    }
}
