package com.example.information.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.information.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByInfoId(long infoId);
}
