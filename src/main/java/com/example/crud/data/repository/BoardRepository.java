package com.example.crud.data.repository;

import com.example.crud.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByEmail(String email);
}
