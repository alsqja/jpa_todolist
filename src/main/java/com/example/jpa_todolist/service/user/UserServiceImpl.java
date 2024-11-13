package com.example.jpa_todolist.service.user;

import com.example.jpa_todolist.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.dto.user.UserResDto;
import com.example.jpa_todolist.entity.user.User;
import com.example.jpa_todolist.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResDto signUp(CreateUserReqDto dto) {
        Optional<User> findUser = userRepository.findByEmail(dto.getEmail());

        if (findUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email already exist");
        }

        User saveUser = new User(dto.getName(), dto.getEmail(), dto.getPassword());

        return new UserResDto(userRepository.save(saveUser));
    }
}
