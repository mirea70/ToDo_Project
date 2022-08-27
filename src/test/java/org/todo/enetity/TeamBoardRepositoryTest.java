package org.todo.enetity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.todo.entity.TeamBoard;
import org.todo.repository.TeamBoardRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TeamBoardRepositoryTest {
    @Autowired
    TeamBoardRepository teamBoardRepository;

    @Test
    public void teamBoard_Save_find() {
        teamBoardRepository.save(TeamBoard.builder()

                .title("제목")
                .build());
        assertTrue(teamBoardRepository.findById(1L).isPresent());

        TeamBoard finded = teamBoardRepository.findById(1L).get();

        assertEquals("제목", finded.getTitle());

        assertThat(finded.getTitle(), is("제목"));
    }

    @Test
    public void like_test() {
//        teamBoardRepository.save(TeamBoard.builder()
//                .title("제목")
//                .build());

        TeamBoard finded = teamBoardRepository.findById(1L).get();

        System.out.println(finded.isLike());
    }
}
