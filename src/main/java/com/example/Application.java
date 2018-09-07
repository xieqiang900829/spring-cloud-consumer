package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//为了支持熔断策略。Application启动类添加@EnableCircuitBreaker注解，或换成@SpringCloudApplication

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.client")
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@RefreshScope
@RestController
public class Application {

	//开启软均衡负载
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//服务启动的时候、读取对应的配置信息、找不到会报错
	//属性热加载前，都要手工调用各个应用的刷新接口，即便使用 Git 仓库的 Webhooks，维护起来也够费劲的
	@Value("${foo}")
	private  String foo;

	@RequestMapping(value = "/getConfig")
	public String foo(){
		return foo;
	}


}
