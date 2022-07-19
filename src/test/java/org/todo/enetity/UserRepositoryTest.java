package org.todo.enetity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.todo.entity.User;
import org.todo.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

//    @AfterEach
//    public void clanup() {
//        userRepository.deleteAll();
//    }

    @Test
    public void user_save_find() {
        //given
        String name = "홍길동";

        userRepository.save(User.builder()
                .userId(1L)
                .name(name)
                .build()
        );

        assertTrue(userRepository.findById(1L).isPresent());
        //when
        User findUser = userRepository.findById(1L).get();
        //then
        assertEquals(name, findUser.getName());
    }
}
