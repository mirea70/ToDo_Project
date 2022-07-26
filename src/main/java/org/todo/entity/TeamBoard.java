package org.todo.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

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

    @Column(length = 3000)
    private String content;

    private String writer;  // User 클래스의 name 필드와 동일시할지 고민

    private int viewCnt = 0;

    private int commentCnt = 0;

    @OneToMany(mappedBy = "user", targetEntity = User_TeamBoard.class)
//    @Builder.Default
    private List<User> wish_list = new ArrayList<>();

    private int wishCnt = 0;

//    @Column(columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean like = false;

    public void update_Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update_view(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public void change_Like() {
        this.like = true;
    }

    public void update_wish_list(User user) {
        wish_list.add(user);
    }
}