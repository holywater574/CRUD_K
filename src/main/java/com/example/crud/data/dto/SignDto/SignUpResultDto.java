package com.example.crud.data.dto.SignDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpResultDto {
    private boolean success;

    private int code;

    private String msg;
}