package com.slbootcamp.foodbox.controller;

import com.slbootcamp.foodbox.entity.User;
import com.slbootcamp.foodbox.jdbc.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDao userDao;

    //    POST -> "/login/
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userDao.login(user);
    }
}
