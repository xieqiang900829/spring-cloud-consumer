package com.example.controller;

import com.example.client.ComputeClient;
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



    @HystrixCommand(commandProperties = {
            //设置熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //时间滚动中最小请求参数，只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
            //错误百分比，判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "40")
    })
    @RequestMapping(value = "/multi")
    public String multi() {
        System.out.println("world");
        Long  result = computeClient.multi(100L,200L);
        System.out.println("result= "+result);
        return  "success";
    }


    @RequestMapping(value = "/sub")
    public String sub() {
        // consumerService.add(10,15);
        //String  result  = computeClient.sub(500L);
        System.out.println("world");
        computeClient.sub(100L);
        return  "success";
    }


}
