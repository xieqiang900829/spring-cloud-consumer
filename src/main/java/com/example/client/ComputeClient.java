package com.example.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by WD42700 on 2018/8/19.
 */
@FeignClient(value = "compute-service" )
public interface ComputeClient {
    //熔断触发时候的处理、日志的处理
    //@FeignClient(value = "fangjia-fsh-house-service", path = "/house", configuration = FeignConfiguration.class, fallback = HouseRemoteClientHystrix.class)


    /**
     * 减法
     * @param
     * @return
     */
    @GetMapping("/sub/{a}")
    public void  sub(@PathVariable("a")Long a);

    /**
     * 乘法
     * @param
     * @return
     */
    @GetMapping("/multi/{a}/{b}")
    public Long multi(@PathVariable("a")Long a,@PathVariable("b")Long b);



}
