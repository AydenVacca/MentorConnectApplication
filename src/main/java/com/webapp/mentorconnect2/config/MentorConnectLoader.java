package com.webapp.mentorconnect2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.models.ForumPost;
import com.webapp.mentorconnect2.models.Comment;
import com.webapp.mentorconnect2.repository.AccountService;
import com.webapp.mentorconnect2.repository.ForumPostService;
import com.webapp.mentorconnect2.repository.CommentService;

@Component
public class MentorConnectLoader implements CommandLineRunner{
    
    @Autowired
    AccountService accountDB;

    @Autowired
    ForumPostService forumPostDB;

    @Autowired
    CommentService commentDB;

    @Override
    public void run(String... args) throws Exception {
        localSeedData();
    }
    
    private void localSeedData(){
        if (accountDB.count() == 0){
            Account account1 = new Account("BobbyBoy", "password");
            Account account2 = new Account("Darrel", "204324");

            accountDB.save(account1);
            accountDB.save(account2);
        }

        if (forumPostDB.count() == 0){
            ForumPost post1 = new ForumPost("IT 279 Disjoint Sets", "I'm having troubles understanding the basic logic behind disjoint sets. Can someone explain it to me?", 1);
            ForumPost post2 = new ForumPost("Database setup", "Hey Everyone can I get some help trying to figure out how to setup an h2 database that uses spring boot and thymeleaf for its implementation?", 2);

            forumPostDB.save(post1);
            forumPostDB.save(post2);
        }

        if (commentDB.count() == 0){
            Comment comment1 = new Comment("Check the video youtube video professor Califf made.", 1, 1, 1);
            

            commentDB.save(comment1);
        }
    }
}
