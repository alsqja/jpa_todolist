package com.example.jpa_todolist.service.todo;

import com.example.jpa_todolist.dto.todo.CreateTodoReqDto;
import com.example.jpa_todolist.dto.todo.TodoResDto;

public interface TodoService {
    TodoResDto save(CreateTodoReqDto dto);

    TodoResDto findById(Long id);
}
