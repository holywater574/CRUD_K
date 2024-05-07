package com.example.crud.data.dao;

import com.example.crud.data.entity.Board;

public interface BoardDAO {
    Board insertBoard(Board board);

    Board selectBoard(String email) throws Exception;

    Board updateBoardName(String email, String name) throws Exception;

    void deleteBoard(String email) throws Exception;

}
