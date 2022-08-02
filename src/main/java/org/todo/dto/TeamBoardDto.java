package org.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.todo.entity.User;

import java.util.List;


@Getter
public class TeamBoardDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDto {
        private Long bno;
        private String title;
        private String content;
        private String writer;
        private int viewCnt;
        private int commentCnt;
        private List<User> wish_list;
        private int wishCnt;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDto {
        private String title;
        private String content;
        private String writer;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PatchDto {
        private String title;
        private String content;
    }
}
