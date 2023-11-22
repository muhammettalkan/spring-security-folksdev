package com.example.basicauth.service;

import com.example.basicauth.dto.CreateUserRequest;
import com.example.basicauth.model.User;
import com.example.basicauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User create(CreateUserRequest request){
        User user = User.builder()
                .name(request.name())
                .username(request.username())
                .password(bCryptPasswordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .build();
        return userRepository.save(user);
    }

}
