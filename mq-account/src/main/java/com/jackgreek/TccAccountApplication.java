package com.jackgreek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("com.jackgreek.mapper")
@EnableRabbit
@EnableFeignClients
public class TccAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccAccountApplication.class, args);
    }

}
