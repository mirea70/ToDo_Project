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
    @GetMapping
    public ResponseEntity getMember() {
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
