package com.example.jpa_todolist.v1.service.common;

public interface BaseService<T, DTO> {
    DTO findById(Long id);
}

