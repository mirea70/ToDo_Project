package org.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.todo.dto.UserDto;
import org.todo.entity.User;
import org.todo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String join(@RequestBody UserDto.PostDto postDto) {
        userService.save(postDto);
        return "회원가입 완료";
    }
    // 로그아웃
//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("Authorization", null);
//        response.a
//        return "로그아웃 완료";
//    }
    // 일반 사용자 접근 가능 경로
//    @GetMapping("/user")
//    public String user() {
//        return "user";
//    }

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
