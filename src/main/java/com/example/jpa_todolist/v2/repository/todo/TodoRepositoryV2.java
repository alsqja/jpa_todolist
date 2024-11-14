package com.example.jpa_todolist.v2.repository.todo;

import com.example.jpa_todolist.v1.entity.todo.Todo;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@NonNullApi
public interface TodoRepositoryV2 extends PagingAndSortingRepository<Todo, Long> {
    Page<Todo> findAll(Pageable pageable);
}
