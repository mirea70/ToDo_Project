package org.todo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String loginId;

    private String pwd;

    private String phone;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus = UserStatus.USER_ACTIVE;

    @OneToMany(mappedBy = "user")
    private List<TeamBoard> boards = new ArrayList<>();

    public User() {}

    public enum UserStatus {
        USER_ACTIVE("활동 중"),
        USER_SLEEP("휴면 상태");

        @Getter
        private String satus;

        UserStatus(String status) { this.satus = status;}
    }
}
