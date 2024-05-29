package com.example.crud.service;

import com.example.crud.data.dto.SignDto.SignInResultDto;
import com.example.crud.data.dto.SignDto.SignUpDto;
import com.example.crud.data.dto.SignDto.SignUpResultDto;

public interface SignService {
    SignUpResultDto SignUp(SignUpDto sIgnUpDto, String roles);
    SignInResultDto SignIn(String email, String password);
}
