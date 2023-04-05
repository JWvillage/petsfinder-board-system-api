package com.example.petsfinderboardsystemapi.aggregate.common.logic;

import com.example.petsfinderboardsystemapi.aggregate.common.service.BoardCrudService;
import com.example.petsfinderboardsystemapi.entity.jpo.BoardEntityJpo;
import com.example.petsfinderboardsystemapi.entity.vo.BoardEntity;
import com.example.petsfinderboardsystemapi.store.BoardStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCrudLogic implements BoardCrudService {
  
  @Autowired
  BoardStore boardStore;
  
  @Override
  public BoardEntity retrieveBoard(String boardId) {
    return boardStore.retrieveBoard(boardId).toDomain("retrieve");
  }
  
  @Override
  public BoardEntity createBoard(BoardEntity boardEntity) {
    return boardStore.createBoard(new BoardEntityJpo(boardEntity)).toDomain("create");
  }
  
  @Override
  public int deleteBoard(String boardId) {
    return boardStore.deleteBoard(boardId);
  }
  
  @Override
  public int updateBoard(String title, String content, String boardId) {
    return boardStore.updateBoard(title, content, boardId);
  }
}
