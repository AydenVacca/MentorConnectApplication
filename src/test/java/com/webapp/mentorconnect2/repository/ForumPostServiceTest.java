package com.webapp.mentorconnect2.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.webapp.mentorconnect2.models.ForumPost;

@DataJpaTest
public class ForumPostServiceTest {
    
    @Autowired
    private ForumPostService fpDB;

    private ForumPost testFP;
    
    @BeforeEach
    void setup(){
        testFP = new ForumPost();
        testFP.setContent("woop woop");
        testFP.setAuthorID(6);
        testFP.setTitle("howdy");
    }

    @Test
    void saveTest(){
        ForumPost savedForumPost = fpDB.save(testFP);
        assertNotNull(savedForumPost.getPostID());
    }

    @Test
    void findById(){
        ForumPost savedForumPost = fpDB.save(testFP);
        Optional<ForumPost> foundForumPost = fpDB.findById(savedForumPost.getPostID());
        assertEquals(savedForumPost, foundForumPost.get());
    }

    @Test
    void findAll(){
        fpDB.save(testFP);
        List<ForumPost> ForumPosts = (List<ForumPost>) fpDB.findAll();
        assertEquals(1, ForumPosts.size());
    }

    @Test
    void delete(){
        ForumPost savedForumPost = fpDB.save(testFP);
        fpDB.deleteById(savedForumPost.getPostID());
        Optional<ForumPost> foundForumPost = fpDB.findById(savedForumPost.getPostID());
        assertEquals(false, foundForumPost.isPresent());
    }
}
