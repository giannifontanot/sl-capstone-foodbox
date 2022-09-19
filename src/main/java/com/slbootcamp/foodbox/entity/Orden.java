package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class Orden {

    private String status;
    private Box box;
    private User user;

}
