package com.example.jpa_todolist.dto.todo;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateTodoReqDto {

    @Size(min = 1, max = 20, message = "length of title is min 1 max 20")
    private final String title;

    private final String contents;

    public UpdateTodoReqDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
    }
}
