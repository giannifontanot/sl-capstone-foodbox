package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    final String INSERT_FOOD_ITEM = "INSERT INTO FOOD SET " +
            " (CUISINE, DESCRIPTION, FOOD_NAME, IMAGE_URL, IS_ENABLED, PRICE)" +
            " VALUES (?,?,?,?,?,?)";

    final String UPDATE_FOOD_ITEM = "UPDATE FOOD SET cuisine = ?, description = ?, food_name = ?, image_url = ?, " +
            "is_enabled = ?, price = ? WHERE id = ?";

    final String SELECT_ALL_FOOD = "SELECT * FROM food";

    final String DELETE_FOOD_ITEM = "DELETE FROM food WHERE id = ?";

    public List<Food> getAllFoods() {
    return jdbcTemplate.query(SELECT_ALL_FOOD, new BeanPropertyRowMapper<>(Food.class));

    }

    final String TOOGLE_FOOD_ITEM = "UPDATE FOOD SET is_enabled = ? WHERE id = ?";

    public int addFoodItem(Food food) {;
        return jdbcTemplate.update(INSERT_FOOD_ITEM, food.getCuisine(), food.getDescription(), food.getFoodName(),
                food.getImageUrl(), food.getIsEnabled(), food.getPrice());
    }

    public int editFoodItem(Food food) {
        return jdbcTemplate.update(UPDATE_FOOD_ITEM, food.getCuisine(), food.getDescription(), food.getFoodName(),
                food.getImageUrl(), food.getIsEnabled(), food.getPrice(), food.getId());
    }

    public int deleteFoodItem(Food food) {
        return jdbcTemplate.update(DELETE_FOOD_ITEM, food.getId());
    }

    public int toogleFoodItem(Food food) {
        return jdbcTemplate.update(TOOGLE_FOOD_ITEM, food.getIsEnabled(), food.getId());
    }
}
