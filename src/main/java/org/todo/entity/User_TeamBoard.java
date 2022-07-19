package org.todo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User_TeamBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_TeamBoard_Id;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    @ManyToOne
    @JoinColumn(name = "TEAM_BOARD")
    private TeamBoard teamBoard;

}
