package com.example.service;

import com.example.client.ComputeClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WD42700 on 2018/9/4.
 */
@Service
public class ComputeService {

    /**
     * 方法级别的熔断执行验证成功
     * 接口请求的次数  != 实际server端执行的次数 + 熔断回退方法的执行【因为刚开始的时候是server端执行超时、然后clent端执行了fallback方法 两边都执行了 】
     * 在熔断出发之后的一段时间内 请求不会被转发到server端、而是直接调用fallback方法并返回
     *
     */

    /**
     * 类级别的熔断执行验证还没有结束
     *
     *
     */

    @Autowired
    private ComputeClient computeClient;

    public void  sub(Long a){
        computeClient.sub(a);
    }

    @HystrixCommand(fallbackMethod="fallBackMulti",
            commandProperties = {
            //设置熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //时间滚动中最小请求参数，只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            //休眠时间窗
            // @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
            // 错误百分比，判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "1")
            //@HystrixProperty(name = "circuitBreaker.fallbackMethod", value = "fallBackMulti")
    })
    public Long multi(Long a,Long b){
        return  computeClient.multi(a,b);
    }

    public  static  int  count =0;
    public Long fallBackMulti(Long a,Long b){
        count ++;
        System.out.println("ComputeClientHystrix multi  第"+count+"次触发了熔断机制");
        return  99999999999888888L;
    }

}
