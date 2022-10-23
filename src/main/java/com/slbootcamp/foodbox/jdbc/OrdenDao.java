package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.DisplayOrden;
import com.slbootcamp.foodbox.entity.Food;
import com.slbootcamp.foodbox.entity.Orden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdenDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    String INSERT_FOOD_ITEM = "INSERT INTO box (ID, FOOD_ID, QUANTITY) VALUES (?,?,?)";
    final String INSERT_ORDEN = "INSERT INTO orden (BOX_ID, USER_ID, STATUS) VALUES (?,?,'PENDING')";

    final String SELECT_ORDEN = "SELECT user.username, orden.id, CONCAT(food.food_name, \" (\",box.quantity,\")\") as food_name, food.price, orden.status " +
            " FROM food, user, box, orden " +
            " WHERE orden.box_id = box.id " +
            " AND orden.user_id = user.id " +
            " AND box.food_id = food.id " +
            " AND user.id = ? " +
            " ORDER BY orden.id DESC";

    final String UPDATE_CLIENT = "UPDATE user SET NAME = ?, CONTACT=?, CREDIT = ? WHERE ID = ? ";


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<DisplayOrden> getDisplayOrden(int ordenId) {
        return jdbcTemplate.query(SELECT_ORDEN, new OrdenDao.DisplayOrdenMapper(), ordenId);
    }

    public int saveOrden(Orden orden) {
        String pkBox = generatePK();
        //Save cart items

        List<Food> cart = orden.getCart();
        Map<Integer, Integer> foodMap = new <Integer, Integer>HashMap();

        for (Food food : cart) {
            Integer cantidad = 0;
            if(foodMap.containsKey(food.getId())){
                logger.info(" ---------------- containsKey: " + food.getId() + " ----------------");
                cantidad = foodMap.get(food.getId());
                logger.info(" ---------------- cantidad: " + cantidad + " ----------------");
            }

            foodMap.put(food.getId(), ++cantidad);


        }

        // INSERT
        for (Map.Entry<Integer, Integer> foodEntry : foodMap.entrySet()) {
            try {
                jdbcTemplate.update(INSERT_FOOD_ITEM, pkBox, String.valueOf(foodEntry.getKey()), String.valueOf(foodEntry.getValue()));

            } catch (DataAccessException e) {
                logger.error("Could not save food");

            }
        }


        //save orden using user_Id and status="PENDING"
        jdbcTemplate.update(INSERT_ORDEN, pkBox, orden.getUser().getId());

        jdbcTemplate.update(UPDATE_CLIENT, orden.getUser().getName(), orden.getUser().getContact(), orden.getUser().getCredit(), orden.getUser().getId());
        return 1;
    }

    private static String generatePK() {
        return String.valueOf(System.currentTimeMillis());
    }

    private static final class DisplayOrdenMapper implements RowMapper<DisplayOrden> {
        public DisplayOrden mapRow(ResultSet rs, int rowNum) throws SQLException {
            DisplayOrden displayOrden = new DisplayOrden();
            displayOrden.setId(rs.getInt("ID"));
            displayOrden.setUsername(rs.getString("USERNAME"));
            displayOrden.setFoodName(rs.getString("FOOD_NAME"));
            displayOrden.setPrice(rs.getInt("PRICE"));
            displayOrden.setStatus(rs.getString("STATUS"));
            return displayOrden;
        }
    }


}