package com.slbootcamp.foodbox.controller;

import com.slbootcamp.foodbox.entity.Food;
import com.slbootcamp.foodbox.jdbc.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    public FoodController() {
    }

    public FoodController(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Autowired
    FoodDao foodDao;

    @GetMapping("/")
    public String getWelcome(){
        return "Welcome to the Spring Boot FoodBox!";
    }

    @GetMapping("/getAllFoods")
    public List<Food> getAllFoods(){
        return foodDao.getAllFoods();
    }
}
