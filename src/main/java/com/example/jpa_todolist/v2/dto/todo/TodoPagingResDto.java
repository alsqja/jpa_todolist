package com.example.jpa_todolist.v2.dto.todo;

import lombok.Getter;

import java.util.List;

@Getter
public class TodoPagingResDto {

    private final long totalPages;
    private final long totalElements;
    private final List<TodoWithUserAndCommentResDto> datas;

    public TodoPagingResDto(long totalPages, long totalElements, List<TodoWithUserAndCommentResDto> datas) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.datas = datas;
    }
}
