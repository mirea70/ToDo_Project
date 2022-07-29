package org.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.todo.entity.User;
import org.todo.repository.UserRepository;

import java.lang.reflect.Executable;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) {
        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        user.setRole(User.UserRole.ROLE_ADMIN);
        return userRepository.save(user);
    }
}
