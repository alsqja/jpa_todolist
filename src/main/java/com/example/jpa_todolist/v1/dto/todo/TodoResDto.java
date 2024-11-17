package com.example.jpa_todolist.v1.dto.todo;

import com.example.jpa_todolist.v1.entity.todo.Todo;
import com.example.jpa_todolist.v1.service.common.ResDtoBaseType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResDto implements ResDtoBaseType {

    private final Long id;

    private final String title;

    private final String contents;

    private final Long userId;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public TodoResDto(Long id, String title, String contents, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TodoResDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.userId = todo.getUser().getId();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }
}
