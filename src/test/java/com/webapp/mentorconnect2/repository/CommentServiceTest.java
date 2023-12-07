package com.webapp.mentorconnect2.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.webapp.mentorconnect2.models.Comment;

@DataJpaTest
public class CommentServiceTest {
    
    @Autowired
    private CommentService commentDB;

    private Comment testComment;
    
    @BeforeEach
    void setup(){
        testComment = new Comment();
        testComment.setContent("woop woop");
        testComment.setAuthorID(6);
        testComment.setPostID(6);
    }

    @Test
    void saveTest(){
        Comment savedComment = commentDB.save(testComment);
        assertNotNull(savedComment.getCommentID());
    }

    @Test
    void findById(){
        Comment savedComment = commentDB.save(testComment);
        Optional<Comment> foundComment = commentDB.findById(savedComment.getCommentID());
        assertEquals(savedComment, foundComment.get());
    }

    @Test
    void findAll(){
        commentDB.save(testComment);
        List<Comment> comments = (List<Comment>) commentDB.findAll();
        assertEquals(1, comments.size());
    }

    @Test
    void delete(){
        Comment savedComment = commentDB.save(testComment);
        commentDB.deleteById(savedComment.getCommentID());
        Optional<Comment> foundComment = commentDB.findById(savedComment.getCommentID());
        assertEquals(false, foundComment.isPresent());
    }
}
