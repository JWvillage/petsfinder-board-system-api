package com.example.petsfinderboardsystemapi.entity.jpo;

import com.example.petsfinderboardsystemapi.entity.vo.BoardEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "BOARD")
public class BoardEntityJpo {
  
  @Id
  @Column
  private String boardId;
  @Column
  private String title;
  @Column
  private String content;
  @Column
  private String writer;
  @Column
  private String postDate;
  @Column
  private int hits;
  @Column
  private String flag;
  
  public BoardEntityJpo() {
    //
  }
  
  public BoardEntityJpo(BoardEntity boardEntity) {
    this.boardId = boardEntity.getBoardId();
    this.title = boardEntity.getTitle();
    this.content = boardEntity.getContent();
    this.writer = boardEntity.getWriter();
    this.postDate = boardEntity.getPostDate();
    this.hits = boardEntity.getHits();
    this.flag = boardEntity.getFlag();
  }
  
  public BoardEntity toDomain(String flag) {
    if (flag.equals("create"))
      return new BoardEntity(
              this.boardId,
              this.title,
              this.content,
              this.writer,
              this.flag
      );
    else if (flag.equals("update") || flag.equals("retrieve"))
      return new BoardEntity(
              this.boardId,
              this.title,
              this.content,
              this.writer,
              this.postDate,
              this.hits,
              this.flag
      );
    else {
      return new BoardEntity();
    }
  }
  
  public List<BoardEntity> toDomains(List<BoardEntityJpo> boardEntityJpos, String flag) {
    if (boardEntityJpos == null || boardEntityJpos.isEmpty())
      return new ArrayList<>();
    
    return boardEntityJpos.stream()
            .map(jpos -> toDomain(flag))
            .collect(Collectors.toList());
  }

}
