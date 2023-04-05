package com.example.petsfinderboardsystemapi.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BoardEntity {
  private String boardId;
  private String title;
  private String content;
  private String writer;
  private String postDate;
  private int hits;
  private String flag;
  
  public BoardEntity() {
    //
  }
  
  public BoardEntity(
    String boardId,
    String title,
    String content,
    String writer,
    String flag
  ) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sysdate = format.format(date);
    
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.postDate = sysdate;
    this.hits = 0;
    this.flag = flag;
  }
  
  public BoardEntity(
          String boardId,
          String title,
          String content,
          String writer,
          int hits,
          String flag
  ) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sysdate = format.format(date);
    
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.postDate = sysdate;
    this.hits = hits;
    this.flag = flag;
  }
}
