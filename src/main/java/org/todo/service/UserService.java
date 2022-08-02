package org.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.todo.dto.UserDto;
import org.todo.entity.User;
import org.todo.repository.UserRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Executable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(UserDto.PostDto postDto) {
        User user = User.builder()
                        .name(postDto.getName())
                        .pwd(bCryptPasswordEncoder.encode(postDto.getPwd()))
                        .phone(postDto.getPhone())
                        .userStatus(User.UserStatus.USER_ACTIVE)
                        .role(User.UserRole.ROLE_USER)
                        .build();
        return userRepository.save(user);
    }

    public int update(UserDto.PatchDto patchDto, Long userId) {
        int changeCnt = 0;
        User findUser = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다. ID = " + userId));
        if(patchDto.getName() != null && findUser.getName() != patchDto.getName()) changeCnt++;
        if(patchDto.getPwd() != null && findUser.getPwd() != patchDto.getPwd()) changeCnt++;
        if(patchDto.getPhone() != null && findUser.getPhone() != patchDto.getPhone()) changeCnt++;
        if(patchDto.getStatus() != null && findUser.getUserStatus() != patchDto.getStatus()) changeCnt++;

        findUser.update(patchDto.getName(), patchDto.getPwd(),
                    patchDto.getPhone(), patchDto.getStatus());
        return changeCnt;
    }

    public UserDto.ResponseDto getUserId(Long userId) {
        User finded = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다. ID = " + userId));
        return new UserDto.ResponseDto(finded);
    }

    public List<UserDto.ResponseDto> getUserList() {
        return userRepository.findAll().stream()
                .map(UserDto.ResponseDto::new).collect(Collectors.toList());
    }

    public void userGetOut(Long userId) {
        User finded = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다. ID = " + userId));

        userRepository.deleteById(userId);
    }
}
