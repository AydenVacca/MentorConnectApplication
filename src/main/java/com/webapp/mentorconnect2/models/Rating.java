package com.webapp.mentorconnect2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String menteeName;

    @Getter @Setter
    private String mentorName;

    @Getter @Setter
    private int rating;

    public Rating() {
    }

    // Constructor with parameters
    public void Rating(String menteeName, String mentorName, int rating) {
        this.menteeName = menteeName;
        this.mentorName = mentorName;
        this.rating = rating;
    }
}
