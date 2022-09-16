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


    final String SELECT_ALL_FOOD = "SELECT * FROM food";
    public List<Food> getAllFoods() {
    return jdbcTemplate.query(SELECT_ALL_FOOD, new BeanPropertyRowMapper<>(Food.class));

    }
}
