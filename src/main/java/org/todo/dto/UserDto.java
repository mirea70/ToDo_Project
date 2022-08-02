package org.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.todo.entity.User;

@Getter
public class UserDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDto {

        private String name;

        private String phone;

        private User.UserStatus status;

        private User.UserRole role;

        public ResponseDto(User userEntity) {
            this.name = userEntity.getName();
            this.phone = userEntity.getPhone();
            this.status = userEntity.getUserStatus();
        }
    }

    @Getter
    @Builder
    public static class PostDto {
        private String name;
        private String pwd;
        private String phone;
    }

    @Getter
    @Builder
    public static class PatchDto {
        private String name;
        private String pwd;
        private String phone;
        private User.UserStatus status;
    }
}
