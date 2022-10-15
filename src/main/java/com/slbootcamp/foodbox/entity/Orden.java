package com.slbootcamp.foodbox.entity;

import lombok.Data;

import java.util.List;

@Data
public class Orden {

    private String status;
    private List<Food> cart;
    private User user;

}
