package com.slbootcamp.foodbox.controller;

import com.slbootcamp.foodbox.entity.Box;
import com.slbootcamp.foodbox.entity.Food;
import com.slbootcamp.foodbox.entity.Orden;
import com.slbootcamp.foodbox.entity.User;
import com.slbootcamp.foodbox.jdbc.FoodDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * find about the ResponseTransfer
 */

@CrossOrigin(origins ="*", allowedHeaders = "*")
@RestController
public class FoodController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public FoodController() {
    }


    @Autowired
    FoodDao foodDao;

    @GetMapping("/")
    public String getWelcome() {
        return "Welcome to the Spring Boot FoodBox!";
    }

    @GetMapping("/food/getAllFoods")
    public List<Food> getAllFoods() {
        return foodDao.getAllFoods();
    }

    //    POST -> "/addFoodItem"(FoodItem) -> adds the food item
    @PostMapping("/food/addFoodItem")
    public int addFoodItem(@RequestBody Food food) {
        logger.info("---------------> food " + food);
        int ret = foodDao.addFoodItem(food);

        logger.info("---------------> " + String.valueOf(ret));
        return ret;
    }

    //    PUT ->"/editFoodItem"(FoodItem) -> edits the food item and saves it back
    @PutMapping("/food/editFoodItem")
    public int editFoodItem(@RequestBody Food food) {
        logger.info("---------------> food " + food);
        int ret = foodDao.editFoodItem(food);
        return ret;
    }

    //    DELETE -> "/deleteFoodItem"(FoodItem) -> remove the food item
    @DeleteMapping("/food/deleteFoodItem")
    public int deleteFoodItem(@RequestBody Food food) {
        logger.info("---------------> food " + food);
        int ret = foodDao.deleteFoodItem(food);
        return ret;
    }

    //    PUT -> toogleFoodItemAvailablity ->"/enableOrDisable"(FoodItem, toggleValue) -> change the availability of the food
    @PutMapping("/food/toogleFoodItem")
    public int toogleFoodItem(@RequestBody Food food) {
        logger.info("---------------> food " + food);
        int ret = foodDao.toogleFoodItem(food);
        return ret;
    }


}
