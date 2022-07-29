package org.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.todo.entity.User;
import org.todo.service.UserService;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    // 홈 화면
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(@RequestBody User user) {
        userService.save(user);
        return "회원가입 완료";
    }

    // 일반 사용자 접근 가능 경로
    @GetMapping("/user")
    public String user() {
        return "user";
    }

    // 매니저 접근 가능 경로
    @GetMapping("/boss")
    public String manager() {
        return "You are TeamBoss";
    }

    // 관리자 접근 가능 경로
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
