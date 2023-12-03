package com.webapp.mentorconnect2.repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.mentorconnect2.models.ForumPost;

public interface ForumPostService extends CrudRepository<ForumPost, Long>{
    
}
