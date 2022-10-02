package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.Orden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class OrdenDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final String INSERT_FOOD_ITEM = "INSERT INTO BOX (FOOD_ID) VALUES (?)";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int placeOrden(Orden orden){



        logger.info("---------------> food " + orden);
        return jdbcTemplate.update(INSERT_FOOD_ITEM,orden);
    }

}
