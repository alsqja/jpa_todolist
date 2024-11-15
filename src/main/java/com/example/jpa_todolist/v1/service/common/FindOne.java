package com.example.jpa_todolist.v1.service.common;

public interface FindOne<T> {
    public T findById(Long id);
}
