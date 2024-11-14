package com.example.jpa_todolist.v2.dto.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoWithUserAndCommentResDto {

    private final Long id;
    private final String title;
    private final Integer commentsCount;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public TodoWithUserAndCommentResDto(Long id, String title, Integer commentsCount, String userName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.commentsCount = commentsCount;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
