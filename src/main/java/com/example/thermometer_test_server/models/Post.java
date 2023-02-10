package com.example.thermometer_test_server.models;


import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    private Long id;
    private String value;

    public Post() {
    }

    public Post(Long id,String value) {
        this.id=id;
        this.value = value;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
