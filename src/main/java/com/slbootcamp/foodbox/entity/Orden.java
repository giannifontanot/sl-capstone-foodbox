package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class Orden {

    private String status;
    private Cart cart;
    private User user;

}
