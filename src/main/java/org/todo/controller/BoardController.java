package org.todo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.todo.dto.TeamBoardDto;
import org.todo.entity.TeamBoard;
import org.todo.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/teamBoard")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/post")
    public String turnPost() {
        return "post";
    }

    // 글쓰기
    @PostMapping("/post")
    public ResponseEntity PostTeamBoard(@RequestBody TeamBoardDto.PostDto postDto) {
        TeamBoardDto.ResponseDto responseDto = boardService.post(postDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // 글 수정하기
    @PatchMapping("/modify/{bno}")
    public ResponseEntity UpdateTeamBoard(
            @PathVariable Long bno,
            @RequestBody TeamBoardDto.PatchDto patchDto) {
        boardService.update(patchDto, bno);
        return new ResponseEntity("수정이 완료되었습니다.", HttpStatus.OK);
    }
    // 글 불러오기(페이지네이션)
    @GetMapping
    public ResponseEntity getTeamBoards(
            @RequestBody TeamBoardDto.List_RequestDto list_requestDto) {
//        Page<TeamBoard> get_List = boardService.getList(list_requestDto);
//        List<TeamBoard> find_List = get_List.getContent();
        List<TeamBoard> find_List = boardService.getList_withSearch(list_requestDto);
        return new ResponseEntity<>(find_List, HttpStatus.OK);
    }
    // 글 1개 조회
    @GetMapping("/{bno}")
    public ResponseEntity getTeamBoard(@PathVariable Long bno) {
        TeamBoardDto.ResponseDto response = boardService.getOne(bno);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // 글 지우기
    @DeleteMapping("/{bno}")
    public ResponseEntity deleteTeamBoard(@PathVariable Long bno) {
        boardService.delete(bno);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{bno}")
    public ResponseEntity likeOne(@PathVariable Long bno) {
        return null;
    }
}
