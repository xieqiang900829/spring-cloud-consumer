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
    public void sub(Long a) {
        System.out.println("ComputeClientHystrix  sub 触发了熔断机制");
    }

    /**
     * 乘法
     *
     * @param a
     * @param b
     * @return
     */

    public  static  int  count =0;
    @Override
    public Long multi(Long a, Long b) {
        count ++;
        System.out.println("ComputeClientHystrix multi  第"+count+"次触发了熔断机制");
        return 123456789L;
    }
}
