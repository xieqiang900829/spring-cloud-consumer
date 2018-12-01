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
    private ConsumerService consumerService;  //基于restTemplate

    @Autowired
    private ComputeClient computeClient;  //FeignClient 调用

    @Autowired
    private ComputeService computeService;  //用于测试熔断  封装了 FeignClient

    @RequestMapping(value = "/multi")
    public String multi() {
        System.out.println("world");
        String  result = computeClient.multi(100L,200L);
        System.out.println("result= "+result);
        return  result;
    }

    public  static  int  count =0;
    @RequestMapping(value = "/sub")
    public String sub() {
        count ++;
        System.out.println("接口被调用 "+count+"次");
        String  s= computeService.multi(100L,200L);
        return  s;
    }

    @RequestMapping(value = "/add")
    public String add() {
        Long  s= consumerService.multi(100,200);
        return  s+"";
    }

}
