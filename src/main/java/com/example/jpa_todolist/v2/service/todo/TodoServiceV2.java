package com.example.jpa_todolist.v2.service.todo;

import com.example.jpa_todolist.v2.dto.todo.TodoPagingResDto;

public interface TodoServiceV2 {
    TodoPagingResDto findAll(int page, int offset);
}
