package com.webapp.mentorconnect2.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CommentTest {
    private Comment com;

    @BeforeEach
    void setUp(){
        com = new Comment();
    }

    @Test
    void testConstructor(){
        com = new Comment("This is the content dude", 2, 3, 3);
        assertNotNull(com);
        assertEquals("This is the content dude", com.getContent());
        assertEquals(2, com.getPostID());
        assertEquals(3, com.getAuthorID());
        assertEquals(3, com.getCommentID());
    }

    @Test
    void testSetAndGet(){
        com.setContent("This is the content dude");
        com.setAuthorID(4);
        com.setPostID(4);

        assertEquals("This is the content dude", com.getContent());
        assertEquals(4, com.getAuthorID());
        assertEquals(4, com.getPostID());
    }
}
