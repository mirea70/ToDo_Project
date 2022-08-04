package org.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.todo.dto.TeamBoardDto;
import org.todo.entity.TeamBoard;
import org.todo.entity.User;
import org.todo.repository.TeamBoardRepository;
import org.todo.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final TeamBoardRepository teamBoardRepository;
    private final UserRepository userRepository;

    public TeamBoardDto.ResponseDto post(TeamBoardDto.PostDto postDto) {
        // writer가 존재하는 회원인지 확인
        User finded = userRepository.findByName(postDto.getWriter());
        // 존재하지 않으면, 예외 발생시키기
        if(finded == null)
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        // 존재한다면, 글 저장
        TeamBoard saving_TeamBoard = TeamBoard.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .writer(postDto.getWriter())
                .build();
        TeamBoard after_Saved = teamBoardRepository.save(saving_TeamBoard);
        // Dto에 담아 반환
        TeamBoardDto.ResponseDto responseDto = TeamBoardDto.ResponseDto.builder()
                .bno(after_Saved.getBno())
                .title(after_Saved.getTitle())
                .content(after_Saved.getContent())
                .writer(after_Saved.getWriter())
                .viewCnt(after_Saved.getViewCnt())
                .commentCnt(after_Saved.getCommentCnt())
                .wish_list(after_Saved.getWish_list())
                .wishCnt(after_Saved.getWishCnt())
                .build();
        return responseDto;
    }

    public void update(TeamBoardDto.PatchDto patchDto, Long bno) {
        // 요청한 글이 존재하는 번호인지 확인
        TeamBoard finded = teamBoardRepository.findById(bno).orElseThrow(
                () -> new IllegalArgumentException("해당 글은 존재하지 않습니다.")
        );
        // 요청한 사용자가 글을 등록한 사용자가 맞는지 확인

        System.out.println(patchDto.getWriter());
        System.out.println(finded.getWriter());

        if(!patchDto.getWriter().equals(finded.getWriter())){
            // 맞지 않으면, 에러 발생시키기
            throw new IllegalArgumentException("글을 등록한 회원이 아닙니다.");
        }
        // 맞으면, 저장되있던 글 수정
        finded.update_Post(patchDto.getTitle(), patchDto.getContent());
   }
   @Transactional(readOnly = true)
   public TeamBoardDto.ResponseDto getOne(Long bno) {
       TeamBoard finded = teamBoardRepository.findById(bno).orElseThrow(
               () -> new IllegalArgumentException("해당 글은 존재하지 않습니다.")
       );
       return TeamBoardDto.ResponseDto.builder()
               .bno(finded.getBno())
               .title(finded.getTitle())
               .content(finded.getContent())
               .writer(finded.getWriter())
               .viewCnt(finded.getViewCnt())
               .commentCnt(finded.getCommentCnt())
               .wish_list(finded.getWish_list())
               .wishCnt(finded.getWishCnt())
               .build();
   }

   public Page<TeamBoard> getList(TeamBoardDto.List_RequestDto list_requestDto) {
        return teamBoardRepository.findAll(PageRequest.of(
                list_requestDto.getPage() -1, list_requestDto.getSize(),
                Sort.by("bno").descending()));
   }

   public void delete(Long bno) {
       TeamBoard finded = teamBoardRepository.findById(bno).orElseThrow(
               () -> new IllegalArgumentException("해당 글은 존재하지 않습니다.")
       );
       teamBoardRepository.delete(finded);
   }
}
