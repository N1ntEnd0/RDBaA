package com.example.lab2.DTO;

import com.example.lab2.entity.Users;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class MusicDTO {
    private String name;

    private String authorName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
