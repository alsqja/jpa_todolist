package com.example.jpa_todolist.v1.service.todo;

import com.example.jpa_todolist.v1.dto.todo.CreateTodoReqDto;
import com.example.jpa_todolist.v1.dto.todo.TodoResDto;
import com.example.jpa_todolist.v1.dto.todo.UpdateTodoReqDto;
import com.example.jpa_todolist.v1.entity.todo.Todo;
import com.example.jpa_todolist.v1.entity.user.User;
import com.example.jpa_todolist.v1.repository.todo.TodoRepository;
import com.example.jpa_todolist.v1.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public TodoResDto save(Long userId, CreateTodoReqDto dto) {

        User findUser = userRepository.findByIdOrElseThrow(userId);

        Todo saveTodo = new Todo(dto.getTitle(), dto.getContents());
        saveTodo.setUser(findUser);

        return new TodoResDto(todoRepository.save(saveTodo));
    }

    @Override
    public TodoResDto findById(Long id) {
        return new TodoResDto(todoRepository.findByIdOrElseThrow(id));
    }

    @Override
    public List<TodoResDto> findAll() {
        return todoRepository.findAll().stream().map(TodoResDto::new).toList();
    }

    @Transactional
    @Override
    public TodoResDto update(Long id, Long userId, UpdateTodoReqDto dto) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        if (!findTodo.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid user");
        }

        if (dto.getTitle() != null) {
            findTodo.setTitle(dto.getTitle());
        }
        if (dto.getContents() != null) {
            findTodo.setContents(dto.getContents());
        }

        return new TodoResDto(findTodo);
    }

    @Override
    public void delete(Long id, Long userId) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        if (!findTodo.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid user");
        }

        todoRepository.delete(findTodo);
    }
}
