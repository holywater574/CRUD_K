package com.example.crud.data.repository;

import com.example.crud.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User getByEmail(String email);
    Optional<User> findByUsername(String username);
}
