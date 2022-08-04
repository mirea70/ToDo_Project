package org.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
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
//        private Long bno;
        private String title;
        private String content;
        private String writer;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class List_RequestDto {
        private int page;
        private int size;
    }

    @Getter
    public static class List_ResponseDto<T> {
        private List<T> list;
        private int page;
        private int size;
        private int Total_Postings;
        private int Total_Pages;

        public List_ResponseDto(List<T> list, Page page) {
            this.list = list;
            this.page = page.getNumber() + 1;
            this.size = page.getSize();
            this.Total_Postings = (int)page.getTotalElements();
            this.Total_Pages = page.getTotalPages();
        }
    }
}
