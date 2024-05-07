package com.example.crud.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RequestBoardDto {
    private String name;

    private String title;

    private String content;

    private String email;

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "RequestBoardDto(name=" + this.getName() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", email=" + this.getEmail() + ")";
    }
}
