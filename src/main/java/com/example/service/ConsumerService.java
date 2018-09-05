package com.example.service;

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

    public void  add(Integer a,Integer b) {
        /**
         * 此处默认使用ribbon做负载均衡
         */
        String  result  =  restTemplate.getForObject("http://compute-service/add?a="+a+"&b=" + b, String.class);
        System.out.println("计算结果："+result);
    }

}
