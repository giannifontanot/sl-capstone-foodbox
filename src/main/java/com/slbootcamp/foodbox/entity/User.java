package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long contact;
    private String admin;
}
