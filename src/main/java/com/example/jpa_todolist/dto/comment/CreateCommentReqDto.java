package com.example.jpa_todolist.dto.comment;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCommentReqDto {

    @NotNull(message = "contents is required")
    private final String contents;

    @NotNull(message = "todoId is required")
    private final Long todoId;

    public CreateCommentReqDto(String contents, Long todoId) {
        this.contents = contents;
        this.todoId = todoId;
    }
}
