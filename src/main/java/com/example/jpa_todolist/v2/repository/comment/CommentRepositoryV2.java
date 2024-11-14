package com.example.jpa_todolist.v2.repository.comment;

import com.example.jpa_todolist.v1.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepositoryV2 extends JpaRepository<Comment, Long> {

    List<Comment> findByTodoIdOrderByUpdatedAtDesc(Long id);

    List<Comment> findByUserIdOrderByUpdatedAtDesc(Long id);
}
