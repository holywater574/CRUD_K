package com.example.crud.data.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestBoardDto {

    private String email;

    private String name;

    private String password;

    private String profile;

    private String number;
}
