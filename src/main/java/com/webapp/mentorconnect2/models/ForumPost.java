package com.webapp.mentorconnect2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "ForumPost")
public class ForumPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long postID;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    //Default constructor for display purposes
    public ForumPost(){

    }

    public ForumPost(String title, String content){
        this.title = title;
        this.content = content;
    }
}
