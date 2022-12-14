package com.slbootcamp.foodbox;

import com.slbootcamp.foodbox.jdbc.FoodDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SlCapstoneFoodboxApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FoodDao foodDao;
    public static void main(String[] args) {
        SpringApplication.run(SlCapstoneFoodboxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
