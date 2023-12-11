package com.webapp.mentorconnect2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long userId;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String confirmPassword;

    @Getter
    @Setter
    private String role;
    
    // New field for storing the user's role

    // Default constructor for display purposes
    public Account() {

    }

    public Account(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void deleteFavoritePost(ForumPost post){
        favoritePosts.remove(post);
    }
}
