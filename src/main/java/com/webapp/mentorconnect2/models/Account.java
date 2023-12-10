package com.webapp.mentorconnect2.models;

import jakarta.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
        name = "favorite_posts",
        joinColumns = @JoinColumn(name = "account_id"),
        inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    @Getter @Setter
    private List<ForumPost> favoritePosts;
    // Default constructor for display purposes
    public Account() {

    }

    public Account(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
