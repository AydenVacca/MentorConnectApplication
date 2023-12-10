package com.webapp.mentorconnect2.repository;

// ... imports ...

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.models.ForumPost;

@Service
public class AccountManagementService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ForumPostService forumPostService;

    public void addFavoritePost(String username, Long postId) {
        Account account = accountService.findByUsername(username);
        ForumPost post = forumPostService.findById(postId).orElse(null);

        if (account != null && post != null) {
            List<ForumPost> favorites = account.getFavoritePosts();
            if (favorites == null) {
                favorites = new ArrayList<>();
            }
            favorites.add(post);
            account.setFavoritePosts(favorites);
            accountService.save(account);
        }
    }

    public List<ForumPost> getFavoritePosts(String username) {
        Account account = accountService.findByUsername(username);
        return account != null ? account.getFavoritePosts() : new ArrayList<>();
    }

    public void removeFavoritePost(String username, Long postId) {
        Account account = accountService.findByUsername(username);
        ForumPost post = forumPostService.findById(postId).orElse(null);

        if (account != null && post != null) {
            account.getFavoritePosts().remove(post);
            accountService.save(account);
        }
    }

    // ... other methods ...
}
