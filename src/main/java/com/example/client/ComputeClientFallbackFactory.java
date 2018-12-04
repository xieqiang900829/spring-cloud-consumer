package com.example.client;

import feign.hystrix.FallbackFactory;

/**
 * Created by WD42700 on 2018/12/1.
 */
public class ComputeClientFallbackFactory  implements FallbackFactory<ComputeClient> {
    @Override
    public ComputeClient create(Throwable throwable) {
        return null;
    }
}
