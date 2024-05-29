package com.example.crud.controller;

import com.example.crud.data.dto.request.ChangeNameRequestDto;
import com.example.crud.data.dto.request.RequestBoardDto;
import com.example.crud.data.dto.response.ResponseBoardDto;
import com.example.crud.service.BoardService;
import io.swagger.annotations.ApiImplicitParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board-api")
public class BoardController {

    private Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseBoardDto> getBoard(@RequestParam String email) throws Exception {
        ResponseBoardDto responseBoardDto = boardService.getBoard(email);
        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }
    @ApiImplicitParam(name = "X-AUTH-TOKEN",value="로그인 성공 후 발급 받은 access_token", required = true, dataType ="String",paramType = "header")
    @PostMapping("/save")
    public ResponseEntity<ResponseBoardDto> saveBoard(@RequestBody RequestBoardDto requestBoardDto ){
        ResponseBoardDto responseBoardDto = boardService.saveBoard(requestBoardDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseBoardDto> changeBoardName(@RequestBody ChangeNameRequestDto changeNameRequestDto) throws Exception{
        ResponseBoardDto responseBoardDto = boardService.changeBoardName(changeNameRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardDto);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBoard(String email) throws Exception{
        boardService.deleteBoard(email);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}

