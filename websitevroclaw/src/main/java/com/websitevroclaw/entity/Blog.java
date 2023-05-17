package com.websitevroclaw.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    @Column(length = 100000)
    private String text;
    @Column(length = 100000)
    private String url;
    private String title;

    public Blog(String username, String text, String url, String title) {
        this.username = username;
        this.text = text;
        this.url = url;
        this.title = title;
    }

    public Blog(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
