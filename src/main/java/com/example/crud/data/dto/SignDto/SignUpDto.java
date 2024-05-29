package com.example.crud.data.dto.SignDto;

import lombok.*;

@Data
@Getter
@Setter
public class SignUpDto {
    private String email;
    private String password;
    private String name;
    private String number;
}
