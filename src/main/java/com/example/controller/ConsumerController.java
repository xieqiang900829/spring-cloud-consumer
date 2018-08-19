package com.example.controller;

import com.example.service.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by WD42700 on 2018/8/19.
 */
@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    ConsumerService consumerService;



    @RequestMapping(value = "/test")
    public String add() {
        consumerService.add(10,15);
        return  "success";
    }


}
