package com.example.jpa_todolist.v2.service.todo;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v2.dto.todo.TodoPagingResDto;

import java.util.List;

public interface TodoServiceV2 {
    TodoPagingResDto findAll(int page, int offset);

    List<CommentResDto> findAllTodoComments(Long id);
}
