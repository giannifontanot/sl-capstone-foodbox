package com.slbootcamp.foodbox.controller;

import com.slbootcamp.foodbox.entity.DisplayOrden;
import com.slbootcamp.foodbox.entity.Orden;
import com.slbootcamp.foodbox.entity.User;
import com.slbootcamp.foodbox.jdbc.OrdenDao;
import com.slbootcamp.foodbox.jdbc.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*", allowedHeaders = "*")
@RestController
public class OrdenController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrdenDao ordenDao;

    @PostMapping("/cart/placeOrden")
    public int placeOrden(@RequestBody Orden orden) {
//    public int placeOrden(@ModelAttribute Orden orden) {
        logger.info("---------------> /cart/placeOrden: ");
        logger.info("---------------> Orden: " + orden);


        return 1;
//        int ret =  ordenDao.placeOrden(orden);
//        logger.info(" ret --------> " + ret);
//        return ret;
    }

    @GetMapping("/cart/getDisplayOrden/{id}")
    public List<DisplayOrden> getDisplayOrden(@PathVariable("id") int id) {
        logger.info("---------------> getDisplayOrden: " + id);
        return ordenDao.getDisplayOrden(id);
    }
}
