package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class Food {
    private int id;
    private String foodName;
    private Long price;
    private String cuisine;
    private String description;
    private String isEnabled;
    private String imageUrl;
}
