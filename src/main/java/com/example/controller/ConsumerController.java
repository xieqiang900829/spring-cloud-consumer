package com.example.controller;

import com.example.service.ConsumerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by WD42700 on 2018/8/19.
 */
@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    ConsumerService consumerService;

    /**
     * 采用缺省配置
     * */
    static {
        BasicConfigurator.configure();
    }

    @RequestMapping(value = "/test")
    public String add() {
        int  a=100;
        int  b=200;
        int c= a+b;
        System.out.println(c);
        consumerService.add(10,15);
        return  "success";
    }


}
