package com.example.jpa_todolist.repository.user;

import com.example.jpa_todolist.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no user having id = " + id));
    }

    Optional<User> findByEmailAndPassword(String email, String password);

    default User findByEmailAndPasswordOrElseThrow(String email, String password) {
        return findByEmailAndPassword(email, password).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "check your email and password"));
    }
}
