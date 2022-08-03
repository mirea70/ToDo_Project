package org.todo.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    private String writer;  // User 클래스의 name 필드와 동일시할지 고민

    private int viewCnt = 0;

    private int commentCnt = 0;

    @OneToMany(mappedBy = "user", targetEntity = User_TeamBoard.class)
//    @Builder.Default
    private List<User> wish_list = new ArrayList<>();

    private int wishCnt = 0;

    public void update_Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
