package com.example.crud.data.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChangeNameRequestDto {
    private String email;
    private String name;
}
