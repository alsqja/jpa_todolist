package com.example.jpa_todolist.v1.service.common;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@NoArgsConstructor
public abstract class AbstractBaseService<T, DTO> implements BaseService<T, DTO> {

    private JpaRepository<T, Long> repository;

    protected AbstractBaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public DTO findById(Long id) {
        T entity = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "no data having id = " + id)
        );
        return toResponseDto(entity);
    }

    // 각 서비스에서 구현해야 하는 DTO 변환 메서드
    protected abstract DTO toResponseDto(T entity);
}


