package com.example.jpa_todolist.service.todo;

import com.example.jpa_todolist.dto.todo.CreateTodoReqDto;
import com.example.jpa_todolist.dto.todo.TodoResDto;
import com.example.jpa_todolist.dto.todo.UpdateTodoReqDto;

import java.util.List;

public interface TodoService {
    TodoResDto save(Long userId, CreateTodoReqDto dto);

    TodoResDto findById(Long id);

    List<TodoResDto> findAll();

    TodoResDto update(Long id, Long userId, UpdateTodoReqDto dto);

    void delete(Long id, Long userId);
}
