package com.example.jpa_todolist.repository.comment;

import com.example.jpa_todolist.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
