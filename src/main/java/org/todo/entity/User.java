package org.todo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String loginId;

    private String pwd;

    private String phone;

    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private UserStatus userStatus = UserStatus.USER_ACTIVE;

    @OneToMany(mappedBy = "teamBoard", targetEntity = User_TeamBoard.class)
//    @Builder.Default
    private List<TeamBoard> boards = new ArrayList<>();

    public enum UserStatus {
        USER_ACTIVE("활동 중"),
        USER_SLEEP("휴면 상태");

        @Getter
        private final String satus;

        UserStatus(String status) { this.satus = status;}
    }
}
