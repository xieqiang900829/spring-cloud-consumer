package com.example.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by WD42700 on 2018/8/21.
 */
@Component
public class ComputeClientHystrix   implements  ComputeClient{

    /**
     * 减法
     *
     * @param a@return
     */
    @Override
    public void sub(@PathVariable("a") Long a) {
        System.out.println("ComputeClientHystrix  触发了熔断机制  sub");
    }

    /**
     * 乘法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public Long multi(@PathVariable("a") Long a, @PathVariable("b") Long b) {
        System.out.println("ComputeClientHystrix  触发了熔断机制  multi");
        return 9999999L;
    }
}
