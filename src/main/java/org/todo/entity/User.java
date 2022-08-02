package org.todo.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String pwd;

    private String phone;

    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private UserStatus userStatus = UserStatus.USER_ACTIVE;

    @OneToMany(mappedBy = "teamBoard", targetEntity = User_TeamBoard.class)
//    @Builder.Default
    private List<TeamBoard> boards = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public enum UserRole {
        ROLE_USER("일반 사용자"),
        ROLE_TEAMBOSS("팀장"),
        ROLE_ADMIN("관리자");

        @Getter
        private final String role;

        UserRole(String role) {
            this.role = role;
        }
    }

    public enum UserStatus {
        USER_ACTIVE("활동 중"),
        USER_SLEEP("휴면 상태");

        @Getter
        private final String status;

        UserStatus(String status) { this.status = status;}
    }

    public void update(String name, String pwd, String phone, UserStatus status) {
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.userStatus = status;
    }
}
