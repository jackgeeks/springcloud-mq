package com.jackgreek.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: jackgeeks
 * @ProjectName: gulishop
 * @Package: com.jackgreek.gulishop.product.config
 * @ClassName: MyRabbitMQConfig
 * @Description: @todo
 * @CreateDate: 2021/4/18 18:05
 * @Version: 1.0
 */
@Configuration
public class MyRabbitMQConfig {

    /**
     * 使用JSON序列化机制，进行消息转换
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
