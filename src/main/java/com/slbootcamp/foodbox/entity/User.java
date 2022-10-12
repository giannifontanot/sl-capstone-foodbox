package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private String password;
    private String contact;
    private String credit;
    private String profile;
}
