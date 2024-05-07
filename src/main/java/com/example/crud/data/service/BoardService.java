package com.example.crud.data.service;

import com.example.crud.data.dto.request.ChangeNameRequestDto;
import com.example.crud.data.dto.response.ResponseBoardDto;
import com.example.crud.data.dto.request.RequestBoardDto;

public interface BoardService {
    ResponseBoardDto getBoard(String email) throws Exception;

    ResponseBoardDto saveBoard(RequestBoardDto requestBoardDto);

    ResponseBoardDto changeBoardName(ChangeNameRequestDto changeNameRequestDto) throws Exception;

    void deleteBoard(String email) throws Exception;
}

