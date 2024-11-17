package com.example.jpa_todolist.v1.service.user;

import com.example.jpa_todolist.v1.config.PasswordEncoder;
import com.example.jpa_todolist.v1.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.v1.dto.user.LoginReqDto;
import com.example.jpa_todolist.v1.dto.user.UserResDto;
import com.example.jpa_todolist.v1.entity.user.User;
import com.example.jpa_todolist.v1.repository.user.UserRepository;
import com.example.jpa_todolist.v1.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractBaseService<User, UserResDto> implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super(userRepository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResDto toResponseDto(User user) {
        return new UserResDto(user);
    }

    @Override
    public UserResDto signUp(CreateUserReqDto dto) {
        Optional<User> findUser = userRepository.findByEmail(dto.getEmail());

        if (findUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email already exist");
        }

        String password = passwordEncoder.encode(dto.getPassword());

        User saveUser = new User(dto.getName(), dto.getEmail(), password);

        return toResponseDto(userRepository.save(saveUser));
    }

    @Override
    public UserResDto login(LoginReqDto dto) {
        User findUser = userRepository.findByEmailOrElseThrow(dto.getEmail());

        if (!passwordEncoder.matches(dto.getPassword(), findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "check your password");
        }

        return toResponseDto(findUser);
    }

    @Override
    public void delete(Long id) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }
}
