package org.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.dto.UserDto;
import org.todo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 정보 수정
    @PatchMapping("/{userId}")
    public String  patchMember( @PathVariable Long userId,
                            @RequestBody UserDto.PatchDto patchDto) {
    int cnt = userService.update(patchDto, userId);
        return cnt + "개의 정보가 수정되었습니다.";
    }

    // 회원 1명 조회
    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId) {
        UserDto.ResponseDto response = userService.getUserId(userId);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    // 회원 전체 조회
    @GetMapping
    public ResponseEntity getUsers() {
        List<UserDto.ResponseDto> list = userService.getUserList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // 회원 탈퇴
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.userGetOut(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
