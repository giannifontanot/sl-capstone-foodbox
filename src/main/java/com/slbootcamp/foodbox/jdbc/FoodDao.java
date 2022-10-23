package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FoodDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    final String INSERT_FOOD_ITEM = "INSERT INTO food " +
            " (CUISINE, DESCRIPTION, food_NAME, IMAGE_URL, IS_ENABLED, PRICE)" +
            " VALUES (?,?,?,?,?,?)";

    final String UPDATE_FOOD_ITEM = "UPDATE food SET cuisine = ?, description = ?, food_name = ?, image_url = ?, " +
            "is_enabled = ?, price = ? WHERE id = ?";

    final String SELECT_ALL_FOOD = "SELECT * FROM food order by ID DESC";

    final String SELECT_FOOD_ITEM = "SELECT * FROM food WHERE food.id = ?";

    final String DELETE_FOOD_ITEM = "DELETE FROM food WHERE id = ?";

    final String TOOGLE_FOOD_ITEM = "UPDATE food SET is_enabled = ? WHERE id = ?";

    public List<Food> getAllFoods() {

        return jdbcTemplate.query(SELECT_ALL_FOOD, new BeanPropertyRowMapper<>(Food.class));
    }


    public int addFoodItem(Food food) {
        ;
        return jdbcTemplate.update(INSERT_FOOD_ITEM, food.getCuisine(), food.getDescription(), food.getFoodName(),
                food.getImageUrl(), food.getIsEnabled(), food.getPrice());
    }

    public int updateFoodItem(Food food) {
        return jdbcTemplate.update(UPDATE_FOOD_ITEM, food.getCuisine(), food.getDescription(), food.getFoodName(),
                food.getImageUrl(), food.getIsEnabled(), food.getPrice(), food.getId());
    }

    public Food getFoodItem(int foodId) {
        logger.info("Query for getFoodItem for SELECT_FOOD_ITEM: " + SELECT_FOOD_ITEM);
        return jdbcTemplate.queryForObject(SELECT_FOOD_ITEM, new FoodMapper(), foodId);
    }

    public int deleteFoodItem(int foodId) {
        return jdbcTemplate.update(DELETE_FOOD_ITEM, foodId);
    }

    public int toogleFoodItem(Food food) {
        logger.info("toogleFoodItem: " + food);
        return jdbcTemplate.update(TOOGLE_FOOD_ITEM, food.getIsEnabled(), food.getId());
    }

    private static final class FoodMapper implements RowMapper<Food> {
        public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
            Food food = new Food();
            food.setId(rs.getInt("ID"));
            food.setCuisine(rs.getString("CUISINE"));
            food.setDescription(rs.getString("DESCRIPTION"));
            food.setFoodName(rs.getString("FOOD_NAME"));
            food.setImageUrl(rs.getString("IMAGE_URL"));
            food.setIsEnabled(rs.getString("IS_ENABLED"));
            food.setPrice(rs.getLong("PRICE"));
            return food;
        }
    }
}
