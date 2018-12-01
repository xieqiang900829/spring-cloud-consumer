package com.example.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by WD42700 on 2018/8/19.
 */
/*
name：作为微服务的名称，用于服务发现、去调用哪个服务
url: url一般用于调试，可以手动指定@FeignClient调用的地址
decode404:当发生http 404错误时，如果该字段位true，会调用decoder进行解码，否则抛出FeignException
configuration: Feign配置类，可以自定义Feign的Encoder、Decoder、LogLevel、Contract
fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
fallbackFactory: 工厂类，用于生成fallback类示例，通过这个属性我们可以实现每个接口通用的容错逻辑，减少重复的代码
path: 定义当前FeignClient的统一前缀*/
//fallback  熔断机制：只要调用远程服务失败(微服务响应超时)，就会调用熔断指定的方法。但是在触发熔断之后、继续调用还是会调用server的方法【这个只能称之为容错或者降级、不能叫熔断】
//@FeignClient(value = "compute-service",path ="/compute" , fallback = ComputeClientHystrix.class)

@FeignClient(value = "compute-service",path ="/compute")
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
    public String multi(@PathVariable("a")Long a,@PathVariable("b")Long b);



}
