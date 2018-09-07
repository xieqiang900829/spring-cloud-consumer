package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WD42700 on 2018/9/6.
 */

@RefreshScope
@RestController
public class ConfigController {

   /* //服务启动的时候、读取对应的配置信息、找不到会报错
    //属性热加载前，都要手工调用各个应用的刷新接口，即便使用 Git 仓库的 Webhooks，维护起来也够费劲的
    @Value("${foo}")
    private  String foo;

    @RequestMapping(value = "/getConfig")
    public String foo(){
        return foo;
    }*/

}
