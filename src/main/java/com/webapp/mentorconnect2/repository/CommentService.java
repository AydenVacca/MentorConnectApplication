package com.webapp.mentorconnect2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.webapp.mentorconnect2.models.Comment;

public interface CommentService extends CrudRepository<Comment, Long>{

    @Query("SELECT c FROM Comment c WHERE c.postID = :postID")
    List<Comment> findByPostID(@Param("postID") long postID);
}