package org.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class UserController {

    // 회원정보 등록
    @PostMapping
    public ResponseEntity postMember() {
        return null;
    }

    // 회원 정보 수정
    @PatchMapping
    public ResponseEntity patchMember() {
        return null;
    }

    // 회원 1명 조회
    @GetMapping("/{userId}")
    public ResponseEntity getMember(@PathVariable Long userId) {
        return null;
    }

    // 회원 전체 조회
    @GetMapping
    public ResponseEntity getMembers() {
        return null;
    }

    // 회원 탈퇴
    @DeleteMapping
    public ResponseEntity deleteMember() {
        return null;
    }
}
