package com.webapp.mentorconnect2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.webapp.mentorconnect2.models.ForumPost;
import com.webapp.mentorconnect2.repository.ForumPostService;

@Controller
public class ForumPostFormController {
    
    @Autowired
    private ForumPostService forumPostDB;

    @Autowired
    public void setForumRepository(ForumPostService forumPostDB){
        this.forumPostDB = forumPostDB;
    }

    @GetMapping("/deletePost/{postID}")
    public String deleteForumPost(@PathVariable("postID") long id, Model model){
        ForumPost post = forumPostDB.findById(id).orElseThrow(()-> new IllegalArgumentException("Post " + id + " not found."));
        
        forumPostDB.delete(post);
        return "redirect:/";
    }
}
