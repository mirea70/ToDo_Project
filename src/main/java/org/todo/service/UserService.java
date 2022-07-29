package org.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.todo.entity.User;
import org.todo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
