package com.example.jpa_todolist.repository.todo;

import com.example.jpa_todolist.entity.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
