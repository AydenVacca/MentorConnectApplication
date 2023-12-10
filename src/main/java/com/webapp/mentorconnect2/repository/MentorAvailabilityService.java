package com.webapp.mentorconnect2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.mentorconnect2.models.MentorAvailability;

// No need for @Service annotation here
public interface MentorAvailabilityService extends JpaRepository<MentorAvailability, Long> {

    List<MentorAvailability> findByMentorName(String string);
    // You can add custom query methods if needed
}
