package com.example.petsfinderboardsystemapi.store;

import com.example.petsfinderboardsystemapi.entity.jpo.BoardEntityJpo;

public interface BoardStore {
  
  BoardEntityJpo retrieveBoard(String boardId);
  
  BoardEntityJpo createBoard(BoardEntityJpo boardEntityJpo);
  
  int updateBoard(String title, String content, String boardId);
  
  int deleteBoard(String boardId);
}
