package com.example.crud.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ChangeNameRequestDto {
    private String name;
    private String email;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "ChangeNameRequestDto(name=" + this.getEmail() + ", email=" + this.getEmail() + ")";
    }

}
