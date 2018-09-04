package com.example.controller;

import com.example.client.ComputeClient;
import com.example.service.ComputeService;
import com.example.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    private ConsumerService consumerService;

    @Autowired
    private ComputeClient computeClient;

    @Autowired
    private ComputeService computeService;



    @RequestMapping(value = "/multi")
    public String multi() {
        System.out.println("world");
        Long  result = computeClient.multi(100L,200L);
        System.out.println("result= "+result);
        return  "success";
    }


    @RequestMapping(value = "/sub")
    public String sub() {
        Long  s= computeService.multi(100L,200L);
        return  s+"";
    }


}
