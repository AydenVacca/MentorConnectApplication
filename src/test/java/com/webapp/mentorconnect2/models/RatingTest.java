package com.webapp.mentorconnect2.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RatingTest {

    private Rating rating;

    @BeforeEach
    public void setUp() {
        rating = new Rating();
    }

    @Test
    public void testGetAndSetMenteeName() {
        String menteeName = "John Doe";
        rating.setMenteeName(menteeName);
        assertEquals(menteeName, rating.getMenteeName(), "Mentee name should be the same as set value");
    }

    @Test
    public void testGetAndSetMentorName() {
        String mentorName = "Jane Smith";
        rating.setMentorName(mentorName);
        assertEquals(mentorName, rating.getMentorName(), "Mentor name should be the same as set value");
    }

    @Test
    public void testGetAndSetRating() {
        int ratingValue = 5;
        rating.setRating(ratingValue);
        assertEquals(ratingValue, rating.getRating(), "Rating value should be the same as set value");
    }

    @Test
    public void testGetAndSetId() {
        long id = 1L;
        rating.setId(id);
        assertEquals(id, rating.getId(), "ID should be the same as set value");
    }

    // Additional tests can be implemented if needed
}
