package com.example.jpa_todolist.dto.todo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateTodoReqDto {

    @NotNull(message = "title is required")
    @Size(min = 1, max = 20, message = "length of title is min 1 max 20")
    private final String title;

    @NotNull(message = "contents is required")
    private final String contents;

    @NotNull(message = "userId is required")
    private final Long userId;

    public CreateTodoReqDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
