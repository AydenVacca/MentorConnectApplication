package com.webapp.mentorconnect2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MentorAvailability")
public class MentorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String mentorName;

    @Getter
    @Setter
    private String availability;

    // Default constructor for display purposes
    public MentorAvailability() {
    }

    public MentorAvailability(String mentorName, String availability) {
        this.mentorName = mentorName;
        this.availability = availability;
    }
}

