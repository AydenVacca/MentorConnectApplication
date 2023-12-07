package com.webapp.mentorconnect2.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.mentorconnect2.models.ForumPost;
import com.webapp.mentorconnect2.repository.ForumPostService;

public class ForumPostFormControllerTest {
    
    private ForumPostFormController forumPostFormController;

    @Mock
    private ForumPostService forumPostDB;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        forumPostFormController = new ForumPostFormController();
        forumPostFormController.setForumRepository(forumPostDB);
    }

    @Test
    void testShowCreatePost(){
        String expectedViewName = "createPost";
        String returnedViewName = forumPostFormController.createForumPost();
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testShowEditPost(){
        long id = 2;
        ForumPost post = new ForumPost("test", "test2", id);
        when(forumPostDB.findById(id)).thenReturn(Optional.of(post));

        String expectedViewName = "editPost";
        String returnedViewName = forumPostFormController.editForumPost(id, model);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testShowDeletePost(){
        long postID = 1;
        ForumPost post = new ForumPost();
        post.setPostID(postID);

        when(forumPostDB.findById(postID)).thenReturn(Optional.of(post));

        String result = forumPostFormController.deleteForumPost(postID, model);
        assertEquals("redirect:/home", result);
    }
}
