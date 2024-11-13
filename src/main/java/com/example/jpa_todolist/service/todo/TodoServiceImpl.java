package com.example.jpa_todolist.service.todo;

import com.example.jpa_todolist.dto.todo.CreateTodoReqDto;
import com.example.jpa_todolist.dto.todo.TodoResDto;
import com.example.jpa_todolist.entity.todo.Todo;
import com.example.jpa_todolist.entity.user.User;
import com.example.jpa_todolist.repository.todo.TodoRepository;
import com.example.jpa_todolist.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public TodoResDto save(CreateTodoReqDto dto) {

        User findUser = userRepository.findByIdOrElseThrow(dto.getUserId());

        Todo saveTodo = new Todo(dto.getTitle(), dto.getContents());
        saveTodo.setUser(findUser);

        return new TodoResDto(todoRepository.save(saveTodo));
    }
}
