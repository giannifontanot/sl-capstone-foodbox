package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class DisplayOrden {
    private int id;
    private String username;
    private String foodName;
    private int price;
    private String status;
}
