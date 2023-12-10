package com.webapp.mentorconnect2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.webapp.mentorconnect2.models.Rating; // Add missing import statement
import java.util.List; // Add missing import statement
import java.util.Map;

public interface RatingService extends CrudRepository<Rating, Long> {
    // Methods to retrieve ratings by mentor name, etc., can be added here
    @Query("SELECT new map(r.mentorName as mentorName, AVG(r.rating) as averageRating) FROM Rating r GROUP BY r.mentorName")
List<Map<String, Object>> findAverageRatingsByMentor();

}