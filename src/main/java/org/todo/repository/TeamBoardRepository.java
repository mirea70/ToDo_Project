package org.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todo.entity.TeamBoard;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long> {
}
