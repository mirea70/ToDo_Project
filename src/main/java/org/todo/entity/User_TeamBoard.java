package org.todo.entity;

import javax.persistence.*;

@Entity
public class User_TeamBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_TeamBoard_Id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "TEAM_BOARD_BNO")
    private TeamBoard teamBoard;

}
