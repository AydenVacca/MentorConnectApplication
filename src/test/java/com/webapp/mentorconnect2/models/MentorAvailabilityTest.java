package com.webapp.mentorconnect2.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MentorAvailabilityTest {

    private MentorAvailability mentorAvailability;

    @BeforeEach
    void setUp() {
        mentorAvailability = new MentorAvailability();
    }

    @Test
    void testConstructor() {
        mentorAvailability = new MentorAvailability("Willy", "Monday 10:00 am - 11:00 am");

        assertNotNull(mentorAvailability);
        assertEquals("Willy", mentorAvailability.getMentorName());
        assertEquals("Monday 10:00 am - 11:00 am", mentorAvailability.getAvailability());
    }

    @Test
    void testSetAndGet() {
        mentorAvailability.setMentorName("Willy");
        mentorAvailability.setAvailability("Tuesday 2:00 pm - 3:00 pm");

        assertEquals("Willy", mentorAvailability.getMentorName());
        assertEquals("Tuesday 2:00 pm - 3:00 pm", mentorAvailability.getAvailability());
    }
}
