package com.example.jpa_todolist.v2.controller.todo;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v2.dto.todo.TodoPagingResDto;
import com.example.jpa_todolist.v2.service.todo.TodoServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/todos")
@RequiredArgsConstructor
public class TodoControllerV2 {

    private final TodoServiceV2 todoServiceV2;

    @GetMapping
    public ResponseEntity<TodoPagingResDto> findAllWithPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int offset
    ) {
        return new ResponseEntity<>(todoServiceV2.findAll(page - 1, offset), HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentResDto>> findAllTodoComments(@PathVariable Long id) {
        return new ResponseEntity<>(todoServiceV2.findAllTodoComments(id), HttpStatus.OK);
    }
}
