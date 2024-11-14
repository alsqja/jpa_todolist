package com.example.jpa_todolist.dto.comment;

import com.example.jpa_todolist.entity.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResDto {

    private final Long id;

    private final String contents;

    private final Long userId;

    private final Long todoId;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public CommentResDto(Long id, String contents, Long userId, Long todoId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.contents = contents;
        this.userId = userId;
        this.todoId = todoId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CommentResDto(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.userId = comment.getUser().getId();
        this.todoId = comment.getTodo().getId();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
