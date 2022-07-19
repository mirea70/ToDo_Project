package org.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
