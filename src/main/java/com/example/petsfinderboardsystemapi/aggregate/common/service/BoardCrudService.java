package com.example.petsfinderboardsystemapi.aggregate.common.service;

import com.example.petsfinderboardsystemapi.entity.vo.BoardEntity;

public interface BoardCrudService {
  
  BoardEntity retrieveBoard(String boardId);
  
  BoardEntity createBoard(BoardEntity boardEntity);
  
  int updateBoard(String title, String content, String boardId);
  
  int deleteBoard(String boardId);
}
