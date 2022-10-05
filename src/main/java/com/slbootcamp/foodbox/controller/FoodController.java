package com.slbootcamp.foodbox.controller;

import com.slbootcamp.foodbox.entity.Food;
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



    @GetMapping("/food/getFoodItem/{foodId}")
    public Food getFoodItem(@PathVariable("foodId") int foodId) {

        return foodDao.getFoodItem(foodId);
    }

    @PostMapping("/food/updateFoodItem") //-0
    public int updateFoodItem(@RequestBody Food food){
        logger.info("---------------> UpdateFoodItem: " + food);
        return foodDao.updateFoodItem(food);
    }


    @PostMapping("/food/addFoodItem")
    public int addFoodItem(@RequestBody Food food) {
        logger.info("---------------> food " + food);
        int ret = foodDao.addFoodItem(food);

        logger.info("---------------> " + String.valueOf(ret));
        return ret;
    }
    //    DELETE -> "/deleteFoodItem"(FoodItem) -> remove the food item
    @DeleteMapping("/food/deleteFoodItem/{foodId}")
    public int deleteFoodItem(@PathVariable("foodId") int foodId) {
        logger.info("---------------> food " + foodId);
        int ret = foodDao.deleteFoodItem(foodId);
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
