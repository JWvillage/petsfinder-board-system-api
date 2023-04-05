package com.example.petsfinderboardsystemapi.store.jpastore;

import com.example.petsfinderboardsystemapi.entity.jpo.BoardEntityJpo;
import com.example.petsfinderboardsystemapi.store.BoardStore;
import com.example.petsfinderboardsystemapi.store.repository.BoardCommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardJpaStore implements BoardStore {
  
  @Autowired
  BoardCommonRepository boardCommonRepository;
  
  @Override
  public BoardEntityJpo retrieveBoard(String boardId) {
    return boardCommonRepository.findByBoardId(boardId);
  }
  
  @Override
  public BoardEntityJpo createBoard(BoardEntityJpo boardEntityJpo) {
    return boardCommonRepository.save(boardEntityJpo);
  }
  
  @Override
  public int updateBoard(String title, String content, String boardId) {
    return boardCommonRepository.updateBoard(title, content, boardId);
  }
  
  @Override
  public int deleteBoard(String boardId) {
    return boardCommonRepository.deleteByBoardId(boardId);
  }
}
