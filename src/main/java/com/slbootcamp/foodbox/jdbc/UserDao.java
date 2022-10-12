package com.slbootcamp.foodbox.jdbc;

import com.slbootcamp.foodbox.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String SELECT_USER = "SELECT * FROM User WHERE username=? AND password=? ";

    public User login(User user) {
            return jdbcTemplate.queryForObject(SELECT_USER, new UserMapper(), user.getUsername(), user.getPassword());

    }

    public static final class UserMapper implements RowMapper<User>{
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setProfile(rs.getString("profile"));
            user.setContact(rs.getString("contact"));
            user.setCredit(rs.getString("credit"));

            return user;
        }
    }
}
