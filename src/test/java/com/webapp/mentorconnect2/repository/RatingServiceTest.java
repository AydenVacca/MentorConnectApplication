package com.webapp.mentorconnect2.repository;

import com.webapp.mentorconnect2.models.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RatingServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RatingService ratingService;

    @BeforeEach
    public void setUp() {
        // Set up some test data
        Rating rating1 = new Rating();
        rating1.setMenteeName("User1");
        rating1.setMentorName("Mentor1");
        rating1.setRating(4);
        entityManager.persist(rating1);

        Rating rating2 = new Rating();
        rating2.setMenteeName("User2");
        rating2.setMentorName("Mentor1");
        rating2.setRating(5);
        entityManager.persist(rating2);

        entityManager.flush();
    }

    @Test
    public void whenFindAverageRatingsByMentor_thenReturnAverage() {
        List<Map<String, Object>> averages = ratingService.findAverageRatingsByMentor();
        assertFalse(averages.isEmpty(), "Averages list should not be empty");

        Map<String, Object> average = averages.get(0);
        assertEquals("Mentor1", average.get("mentorName"), "Mentor name should match");
        assertEquals(4.5, (Double) average.get("averageRating"), 0.1, "Average rating should be calculated correctly");
    }
}
