package com.example.crud.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String number;

    @Column
    private String password;

    @Column
    private String profile;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "board")
    @ToString.Exclude
    private BoardDetail boardDetail;

}
