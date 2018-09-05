package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by WD42700 on 2018/8/19.
 */
@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    public Long  multi(Integer a,Integer b) {
        /**
         * 此处默认使用ribbon做负载均衡
         */
        ///multi/{a}/{b}
        String  result  =  restTemplate.getForObject("http://compute-service/compute/multi/"+a+"/" + b, String.class);
        System.out.println("计算结果："+result);
       // return  result;
        return Long.valueOf(result);
    }

}
