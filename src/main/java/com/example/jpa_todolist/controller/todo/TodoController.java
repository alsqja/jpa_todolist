package com.example.jpa_todolist.controller.todo;

import com.example.jpa_todolist.dto.todo.CreateTodoReqDto;
import com.example.jpa_todolist.dto.todo.TodoResDto;
import com.example.jpa_todolist.dto.todo.UpdateTodoReqDto;
import com.example.jpa_todolist.service.todo.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResDto> save(@Valid @RequestBody CreateTodoReqDto dto) {
        return new ResponseEntity<>(todoService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoResDto>> findById() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResDto> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTodoReqDto dto
    ) {
        return new ResponseEntity<>(todoService.update(id, dto), HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
//
//        todoService.delete(id, password);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}