package com.example.crud.data.dao.impl;

import com.example.crud.data.dao.BoardDAO;
import com.example.crud.data.entity.Board;
import com.example.crud.data.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board insertBoard(Board board) {
        Board result = boardRepository.save(board);

        return result;
    }

    @Override
    public Board selectBoard(String email) throws Exception {
        Optional<Board> board = boardRepository.findByEmail(email);

        if (board.isPresent()) {
            Board result = board.get();
            return result;
        }else{
            throw new Exception("찾을 수 없음");
        }
    }


    @Override
    public Board updateBoardName(String email, String name) throws Exception {
        Optional<Board> findBoard = boardRepository.findByEmail(email);

        Board result;

        if(findBoard != null){
            Board board = findBoard.get();

            board.setName(name);
            board.setUpdatedAt(LocalDateTime.now());
            result = boardRepository.save(board);
        }else{
            throw new Exception("찾을 수 없음");
        }
        return result;
    }


    @Override
    public void deleteBoard(String email) throws Exception {
        Optional<Board> findBoard = boardRepository.findByEmail(email);

        if(findBoard != null){
            Board board = findBoard.get();
            boardRepository.delete(board);
        }else{
            throw new Exception("찾을 수 없음");
        }

    }
}
