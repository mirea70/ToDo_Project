package org.todo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
public class TeamBoard {
    @Id
    private Long bno;

    private String title;

    private String content;

    private String writer;  // User 클래스의 name 필드와 동일시할지 고민

    private int viewCnt;

    private int commentCnt;

    @OneToMany(mappedBy = "teamBoard")
    private List<User> wish_list = new ArrayList<>();

    public TeamBoard() {}


}
