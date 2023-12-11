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

import com.webapp.mentorconnect2.models.Comment;
import com.webapp.mentorconnect2.models.ForumPost;
import com.webapp.mentorconnect2.repository.CommentService;
import com.webapp.mentorconnect2.repository.ForumPostService;

public class ForumPostFormControllerTest {
    
    private ForumPostFormController forumPostFormController;

    @Mock
    private ForumPostService forumPostDB;

    @Mock
    private CommentService commentDB;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        forumPostFormController = new ForumPostFormController();
        forumPostFormController.setForumRepository(forumPostDB);
        forumPostFormController.setCommentRepository(commentDB);
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
    void testShowCreateComment(){
        String expectedViewName = "createComment";
        String returnedViewName = forumPostFormController.createComment(1, model);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testShowEditComment(){
        long id = 2;
        Comment comment = new Comment("hi", 2, 2, 2);
        when(commentDB.findById(id)).thenReturn(Optional.of(comment));

        String expectedViewName = "editComment";
        String returnedViewName = forumPostFormController.editComment(id, model);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testShowDeleteComment(){
        long commentID = 1;
        Comment comment = new Comment();
        comment.setCommentID(commentID);

        when(commentDB.findById(commentID)).thenReturn(Optional.of(comment));

        String result = forumPostFormController.deleteComment(commentID, model);
        assertEquals("redirect:/post/0", result); //redirects to /post/0 because comment has no associated post, default 0.
    }
}