package com.example.crud.data.service.impl;

import com.example.crud.data.dao.BoardDAO;
import com.example.crud.data.dto.request.ChangeNameRequestDto;
import com.example.crud.data.dto.request.RequestBoardDto;
import com.example.crud.data.dto.response.ResponseBoardDto;
import com.example.crud.data.entity.Board;
import com.example.crud.data.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoardServiceImpl implements BoardService {

    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public ResponseBoardDto getBoard(String email) {
        try {
            Board board = boardDAO.selectBoard(email);

            ResponseBoardDto responseBoardDto = new ResponseBoardDto();
            responseBoardDto.setPid(board.getPid());
            responseBoardDto.setEmail(board.getEmail());
            responseBoardDto.setName(board.getName());
            responseBoardDto.setContent(board.getContent());
            responseBoardDto.setTitle(board.getTitle());

            return responseBoardDto;
        } catch (Exception e) {
            logger.error("Error occurred while getting board for email: {}", email, e);
            throw new RuntimeException("Failed to get board", e);
        }
    }

    @Override
    public ResponseBoardDto saveBoard(RequestBoardDto requestBoardDto) {
        try {
            Board board = new Board();
            board.setEmail(requestBoardDto.getEmail());
            board.setName(requestBoardDto.getName());
            board.setContent(requestBoardDto.getContent());
            board.setTitle(requestBoardDto.getTitle());
            board.setCreateAt(LocalDateTime.now());
            board.setUpdatedAt(LocalDateTime.now());

            Board savedBoard = boardDAO.insertBoard(board);

            ResponseBoardDto responseBoardDto = new ResponseBoardDto();
            responseBoardDto.setPid(savedBoard.getPid());
            responseBoardDto.setEmail(savedBoard.getEmail());
            responseBoardDto.setName(savedBoard.getName());
            responseBoardDto.setContent(savedBoard.getContent());
            responseBoardDto.setTitle(savedBoard.getTitle());

            return responseBoardDto;
        } catch (Exception e) {
            logger.error("Error occurred while saving board", e);
            throw new RuntimeException("Failed to save board", e);
        }
    }

    @Override
    public ResponseBoardDto changeBoardName(ChangeNameRequestDto changeNameRequestDto) {
        try {
            Board findBoard = boardDAO.updateBoardName(changeNameRequestDto.getEmail(), changeNameRequestDto.getName());

            ResponseBoardDto responseBoardDto = new ResponseBoardDto();
            responseBoardDto.setPid(findBoard.getPid());
            responseBoardDto.setEmail(findBoard.getEmail());
            responseBoardDto.setName(findBoard.getName());
            responseBoardDto.setContent(findBoard.getContent());
            responseBoardDto.setTitle(findBoard.getTitle());

            return responseBoardDto;
        } catch (Exception e) {
            logger.error("Error occurred while changing board name for email: {}", changeNameRequestDto.getEmail(), e);
            throw new RuntimeException("Failed to change board name", e);
        }
    }

    @Override
    public void deleteBoard(String email) {
        try {
            boardDAO.deleteBoard(email);
        } catch (Exception e) {
            logger.error("Error occurred while deleting board for email: {}", email, e);
            throw new RuntimeException("Failed to delete board", e);
        }
    }
}
