package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class Orden {

    private String status;
    private int cart_id;
    private int user_id;

}
