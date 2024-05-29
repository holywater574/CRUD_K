package com.example.crud.data.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseBoardDto {
    private Long pid;

    private String email;

    private String name;

    private String password;

    private String number;

    private String profile;
}