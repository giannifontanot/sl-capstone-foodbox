package com.slbootcamp.foodbox.entity;

import lombok.Data;

@Data
public class Box {
    private Long id;
    private Food foods;
    private Orden orden;
}
