package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.DisplayOrden;
import com.slbootcamp.foodbox.entity.Food;
import com.slbootcamp.foodbox.entity.Orden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrdenDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final String INSERT_FOOD_ITEM = "INSERT INTO BOX (FOOD_ID) VALUES (?)";

    final String SELECT_ORDEN = "SELECT user.username, orden.id, food.food_name, food.price, orden.status " +
    " FROM food, user, box, orden " +
    " WHERE orden.box_id = box.id " +
    " AND orden.user_id = user.id " +
    " AND box.food_id = food.id " +
    " AND user.id = ? " +
    " ORDER BY orden.id DESC";


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<DisplayOrden> getDisplayOrden(int ordenId) {
        logger.info("getOrden");
        return jdbcTemplate.query(SELECT_ORDEN, new OrdenDao.DisplayOrdenMapper(), ordenId);
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