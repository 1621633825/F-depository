package com.ruoyi.common.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
/**
 * @author liangliang
 * @date 2021/10/11 14:22
 */
@Configuration
public class OrderMqConfig {
    // 绑定键
    private final static String order = "topic.order";

    /**
     * 声明队列
     * @return 返回队列实例
     */
    @Bean
    public Queue orderQueue (){
        return new Queue(OrderMqConfig.order);
    }

    /**
     * 声明交换机
     * @return 返回交换机实例
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定队列交换机
     * @return binding
     */
    @Bean
    public Binding bindingExchange() {
        return BindingBuilder.bind(orderQueue()).to(exchange()).with(order);
    }
}
