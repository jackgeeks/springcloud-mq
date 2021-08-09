package com.jackgreek.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * @Author: jackgeeks
 * @ProjectName: gulishop
 * @Package: com.jackgreek.gulishop.product.config
 * @ClassName: FeignConfig
 * @Description: @todo
 * @CreateDate: 2021/4/18 18:05
 * @Version: 1.0
 */
@Configuration
public class MyRabbitConfig {

    private RabbitTemplate rabbitTemplate;

    @Primary
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
