package com.example.crud.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "board_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class BoardDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
