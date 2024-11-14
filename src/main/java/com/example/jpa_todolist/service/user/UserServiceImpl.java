package com.example.jpa_todolist.service.user;

import com.example.jpa_todolist.config.PasswordEncoder;
import com.example.jpa_todolist.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.dto.user.LoginReqDto;
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
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResDto signUp(CreateUserReqDto dto) {
        Optional<User> findUser = userRepository.findByEmail(dto.getEmail());

        if (findUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email already exist");
        }

        String password = passwordEncoder.encode(dto.getPassword());

        User saveUser = new User(dto.getName(), dto.getEmail(), password);

        return new UserResDto(userRepository.save(saveUser));
    }

    @Override
    public UserResDto login(LoginReqDto dto) {
        User findUser = userRepository.findByEmailOrElseThrow(dto.getEmail());

        if (!passwordEncoder.matches(dto.getPassword(), findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "check your password");
        }
        
        return new UserResDto(findUser);
    }

    @Override
    public void delete(Long id) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }
}
