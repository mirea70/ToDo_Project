package org.todo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.todo.entity.TeamBoard;

import java.util.List;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long> {
    List<TeamBoard> findByTitleContaining(String keyword, Pageable pageable);
}
