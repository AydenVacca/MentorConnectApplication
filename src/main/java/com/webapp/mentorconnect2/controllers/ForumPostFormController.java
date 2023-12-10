package com.webapp.mentorconnect2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.models.Comment;
import com.webapp.mentorconnect2.models.ForumPost;
import com.webapp.mentorconnect2.repository.AccountManagementService;
import com.webapp.mentorconnect2.repository.CommentService;
import com.webapp.mentorconnect2.repository.ForumPostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ForumPostFormController {
    
    @Autowired
    private ForumPostService forumPostDB;

    @Autowired
    private AccountService accountDB;

    @Autowired
    public void setAccountRepository(AccountService accountDB){
        this.accountDB = accountDB;
    }

    @Autowired
    private AccountManagementService accountManagementService;

    @Autowired
    public void setForumRepository(ForumPostService forumPostDB){
        this.forumPostDB = forumPostDB;
    }

    @Autowired
    private CommentService commentDB;

    @Autowired
    public void setCommentRepository(CommentService commentDB){
        this.commentDB = commentDB;
    }

    //Delete Posts
    @GetMapping("/deletePost/{postID}")
    public String deleteForumPost(@PathVariable("postID") long id, Model model){
        ForumPost post = forumPostDB.findById(id).orElseThrow(()-> new IllegalArgumentException("Post " + id + " not found."));
        Account account = accountDB.findById(post.getAuthorID()).orElseThrow(()-> new IllegalArgumentException("Account not found."));
        account.deleteFavoritePost(post);
        forumPostDB.delete(post);
        return "redirect:/home";
    }

    //Edit posts
    @GetMapping("/editPost/{postID}")
    public String editForumPost(@PathVariable("postID") long id, Model model){
        Optional<ForumPost> post = forumPostDB.findById(id);

        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping("/editPost/{postID}")
    public String editForumPost(@PathVariable("postID") long id, @ModelAttribute ForumPost updatedPost, HttpSession session){
        ForumPost post = forumPostDB.findById(id).orElseThrow(() -> new IllegalArgumentException("Post " + id + " not found."));
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthorID(updatedPost.getAuthorID());

        long authorID = (long) session.getAttribute("userId");
        post.setAuthorID(authorID);

        forumPostDB.save(post);
        return "redirect:/home";
    }

    //Loads post creation page
    @GetMapping("/createPost")
    public String createForumPost(){
        return "createPost";
    }

    @GetMapping("/create-post")
    public String showCreatePostForm(Model model){
        model.addAttribute("forumPost", new ForumPost());
        return "create-post";
    }

    @PostMapping("/create-post")
    public String createPost(ForumPost forumPost, HttpSession session){
        long authorID = (long) session.getAttribute("userId");
        forumPost.setAuthorID(authorID);
        forumPostDB.save(forumPost);
        return "redirect:/home";
    }

    //View Post
    @GetMapping("/post/{postID}")
    public String postDetail(@PathVariable("postID") long id, Model model, HttpSession session){
        // Optional<ForumPost> post = forumPostDB.findById(id);
        // List<Comment> comments = commentDB.findByPostID(id);
        // model.addAttribute("Comments", comments);
        // post.ifPresent(value -> model.addAttribute("post", value));
        // return "forum";
        model.addAttribute("forumPostFormController", this);
        Optional<ForumPost> postOptional = forumPostDB.findById(id);

        if (postOptional.isPresent()) {
            ForumPost post = postOptional.get();
            List<Comment> comments = commentDB.findByPostID(id);
    
            model.addAttribute("Comments", comments);
            model.addAttribute("post", post);
        }
            return "forum";
    }

    //Delete comments
    @GetMapping("/deleteComment/{commentID}")
    public String deleteComment(@PathVariable("commentID") long id, Model model){
        Comment comment = commentDB.findById(id).orElseThrow(()-> new IllegalArgumentException("Comment " + id + " not found."));
        
        commentDB.delete(comment);
        return "redirect:/post/" + comment.getPostID();
    }

    //Edit Comments
    @GetMapping("/editComment/{commentID}")
    public String editComment(@PathVariable("commentID") long id, Model model){
        Comment comment = commentDB.findById(id).orElseThrow(() -> new IllegalArgumentException("Comment " + id + " not found."));

        model.addAttribute("comment", comment);
        return "editComment";
    }

    @PostMapping("/edit-comment/{commentID}")
    public String editComment(@PathVariable("commentID") long id, @ModelAttribute Comment updatedComment, HttpSession session){
        Comment comment = commentDB.findById(id).orElseThrow(() -> new IllegalArgumentException("Comment " + id + " not found."));
        comment.setContent(updatedComment.getContent());
        long authorID = (long) session.getAttribute("userId");
        comment.setAuthorID(authorID);
        commentDB.save(comment);
        return "redirect:/post/" + comment.getPostID();    
    }

    //Add comment
    @GetMapping("/createComment/{postID}")
    public String createComment(@PathVariable("postID") long postID, Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("postID", postID);
        return "createComment";
    }

    @GetMapping("/create-comment/{postID}")
    public String showCreateCommentForm(@PathVariable("postID") long postID, Model model) {
        Comment comment = new Comment();
        comment.setPostID(postID);
        model.addAttribute("content", new Comment());
        model.addAttribute("postID", postID);
        return "create-comment/" + postID;
    }
    
    @PostMapping("/create-comment/{postID}")
    public String createComment(@PathVariable("postID") long postID, @ModelAttribute Comment comment, HttpSession session) {
        comment.setPostID(postID);
        long authorID = (long) session.getAttribute("userId");
        comment.setAuthorID(authorID);
        commentDB.save(comment);
        return "redirect:/post/" + postID;
    }

    public String getAuthorUsername(long authorID) {
        return accountDB.findById(authorID)
                .map(Account::getUsername)
                .orElse("Unknown");
    }

    public String getAuthorUsername(long authorID) {
        return accountDB.findById(authorID)
                .map(Account::getUsername)
                .orElse("Unknown");
    }
}