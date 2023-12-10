package com.webapp.mentorconnect2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.webapp.mentorconnect2.models.ForumPost;

public interface ForumPostService extends CrudRepository<ForumPost, Long>{
    Optional<ForumPost> findById(Long id);
}
