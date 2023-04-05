package com.example.petsfinderboardsystemapi.store.repository;

import com.example.petsfinderboardsystemapi.entity.jpo.BoardEntityJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardCommonRepository extends JpaRepository<BoardEntityJpo, String> {
  
  BoardEntityJpo findByBoardId(String boardId);
  
  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("update BoardEntityJpo b set b.title =: title, b.content =: content where b.boardId =: boardId")
  int updateBoard(String title, String content, String boardId);
  
  @Modifying(clearAutomatically = true)
  @Transactional
  int deleteByBoardId(String boardId);
}
