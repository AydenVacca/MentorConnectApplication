package com.webapp.mentorconnect2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long commentID;

    @Getter
    @Setter
    private long authorID;

    @Getter
    @Setter
    private long postID;

    @Getter
    @Setter
    private String content;

    //Default constructor
    public Comment(){

    }

    public Comment(String content, long postID, long authorID, long commentID){
        this.commentID = commentID;
        this.authorID = authorID;
        this.postID = postID;
        this.content = content;
    }
}