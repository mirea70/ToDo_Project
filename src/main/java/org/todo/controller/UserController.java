package org.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class UserController {

    @PostMapping
    public ResponseEntity postMember() {
        return null;
    }

    @PatchMapping
    public ResponseEntity patchMember() {
        return null;
    }
    @GetMapping("/{userId}")
    public ResponseEntity getMember(@PathVariable Long userId) {
        return null;
    }
    @GetMapping
    public ResponseEntity getMembers() {
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteMember() {
        return null;
    }
}
