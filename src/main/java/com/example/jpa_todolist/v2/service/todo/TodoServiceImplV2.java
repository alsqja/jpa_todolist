package com.example.jpa_todolist.v2.service.todo;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v1.entity.todo.Todo;
import com.example.jpa_todolist.v2.dto.todo.TodoPagingResDto;
import com.example.jpa_todolist.v2.dto.todo.TodoWithUserAndCommentResDto;
import com.example.jpa_todolist.v2.repository.comment.CommentRepositoryV2;
import com.example.jpa_todolist.v2.repository.todo.TodoRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImplV2 implements TodoServiceV2 {

    private final TodoRepositoryV2 todoRepositoryV2;
    private final CommentRepositoryV2 commentRepositoryV2;

    @Override
    public TodoPagingResDto findAll(int page, int offset) {
        Pageable pageable = PageRequest.of(page, offset, Sort.by("updatedAt").descending());
        Page<Todo> todosPage = todoRepositoryV2.findAll(pageable);

        Page<TodoWithUserAndCommentResDto> todos = todosPage.map(todo -> new TodoWithUserAndCommentResDto(
                todo.getId(),
                todo.getTitle(),
                todo.getComments().size(),
                todo.getUser().getName(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        ));

        return new TodoPagingResDto(todos.getTotalElements(), todos.getTotalPages(), todos.getContent());
    }

    @Override
    public List<CommentResDto> findAllTodoComments(Long id) {
        return commentRepositoryV2.findByTodoIdOrderByUpdatedAtDesc(id).stream().map(CommentResDto::new).toList();
    }
}
