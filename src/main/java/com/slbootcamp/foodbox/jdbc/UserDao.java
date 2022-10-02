package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String SELECT_USER = "SELECT PROFILE FROM User WHERE username=? AND password=? ";

    public String login(User user) {
        String ret = "F";
        try {
            logger.info(SELECT_USER);
            logger.info(SELECT_USER+ " " + user.getUsername());
            logger.info(SELECT_USER+ " " + user.getUsername() + " " + user.getPassword());
            ret = jdbcTemplate.queryForObject(SELECT_USER, String.class, user.getUsername(), user.getPassword());
        } catch (EmptyResultDataAccessException e) {

            logger.warn("User not found: " + user.getUsername());
            return ret;
        }
        return ret;
    }
}
