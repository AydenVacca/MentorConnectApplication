package com.webapp.mentorconnect2.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ForumPostTest {
    private ForumPost fp;

    @BeforeEach
    void setUp(){
        fp = new ForumPost();
    }

    @Test
    void testConstructor(){
        fp = new ForumPost("Waka Waka", "Shakira Shakira", 4);
        assertNotNull(fp);
        assertEquals("Waka Waka", fp.getTitle());
        assertEquals("Shakira Shakira", fp.getContent());
        assertEquals(4, fp.getAuthorID());
    }

    @Test
    void testSetAndGet(){
        fp.setContent("Shakira Shakira");
        fp.setAuthorID(4);
        fp.setTitle("Waka Waka");

        assertEquals("Shakira Shakira", fp.getContent());
        assertEquals(4, fp.getAuthorID());
        assertEquals("Waka Waka", fp.getTitle());
    }
}
