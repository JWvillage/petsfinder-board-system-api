package com.example.petsfinderboardsystemapi.aggregate.common.flow;

import com.example.petsfinderboardsystemapi.aggregate.common.service.BoardCrudService;
import com.example.petsfinderboardsystemapi.aggregate.helper.util.Util;
import com.example.petsfinderboardsystemapi.entity.vo.BoardEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BoardCrudResource {
  
  @Autowired
  BoardCrudService boardCrudService;
  
  @RequestMapping(value = "/v1/apis/PETSFINDER/board/crud")
  public Map<String, String> BoardCrudResource(@RequestBody String boardData) throws ParseException, JsonProcessingException {
  
    return BoardCrudBaseResource(boardData);
  }
  
  public Map<String, String> BoardCrudBaseResource(String boardData) throws ParseException, JsonProcessingException {
    Map<String, String> model = new HashMap<>();
  
    JSONObject jo = Util.StringToJSONObject(boardData);
    
    String active = jo.get("active").toString();
    
    if (active.equals("create")) {
      
      BoardEntity createBoard = new ObjectMapper().convertValue(Util.JSONObectToMap(jo, null), BoardEntity.class);
      BoardEntity retrieveBoard = boardCrudService.retrieveBoard(createBoard.getBoardId());
      
      if (retrieveBoard != null) {
        
        BoardEntity returnBoard = boardCrudService.createBoard(createBoard);
        
        if (returnBoard != null) {
          model.put("status", "200");
          model.put("resultData", new ObjectMapper().writeValueAsString(returnBoard));
        } else {
          model.put("status", "300");
          model.put("errorMsg", "기입 정보가 잘못되었습니다! 다시 확인해주세요!");
        }
      } else {
        model.put("status", "600");
        model.put("errorMsg", "알 수 없는 API 오류입니다!");
      }
    } else if (active.equals("update")) {
      
      int resultData = boardCrudService.updateBoard(jo.get("title").toString(), jo.get("content").toString(), jo.get("boardId").toString());
      
      if (resultData == 1) {
        model.put("status", "200");
        model.put("resultData", "수정되었습니다!");
      } else {
        model.put("status", "600");
        model.put("errorMsg", "알 수 없는 API 오류입니다!");
      }
    } else if (active.equals("delete")) {
      
      int resultData = boardCrudService.deleteBoard(jo.get("boardId").toString());
  
      if (resultData == 1) {
        model.put("status", "200");
        model.put("resultData", "삭제되었습니다!");
      } else {
        model.put("status", "600");
        model.put("errorMsg", "알 수 없는 API 오류입니다!");
      }
    }
    //
    return model;
  }
}
